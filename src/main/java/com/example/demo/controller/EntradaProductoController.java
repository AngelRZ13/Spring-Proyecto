package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.EntradaProducto;
import com.example.demo.entity.Producto;
import com.example.demo.entity.Proveedor;
import com.example.demo.service.CategoriaServices;
import com.example.demo.service.EntradaProductoServices;
import com.example.demo.service.ProductoServices;
import com.example.demo.service.ProveedorServices;

@Controller
@RequestMapping("/entradaProducto")
public class EntradaProductoController {
	
	@Autowired
	private EntradaProductoServices servicioEP;
	
	@Autowired
	private CategoriaServices servicioCat;
	
	@Autowired
	private ProveedorServices servicioProv;
	
	@Autowired
	private ProductoServices servicioProd;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("entradaproductos", servicioEP.listarTodos());
		model.addAttribute("productos", servicioProd.listarTodos());
		model.addAttribute("proveedores", servicioProv.listarTodos());
		model.addAttribute("categorias", servicioCat.listarTodos());
		return "entradaProducto";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer codi,
						 @RequestParam("fecha") String fecha,
						 @RequestParam("productoEntrada") Integer codp,
						 @RequestParam("proveedorEntrada") Integer codpr,
						 @RequestParam("categoriaEntrada") Integer codca,
						 @RequestParam("cantidad") int can,
						 RedirectAttributes redirect) {
		try {
			EntradaProducto ep = new EntradaProducto();
			ep.setFecha(LocalDate.parse(fecha));
			
			Producto pro = new Producto();
			pro.setCodigo(codp);
			ep.setProductoEntrada(pro);
			
			Proveedor prv = new Proveedor();
			prv.setCodigo(codpr);
			ep.setProveedorEntrada(prv);
			
			Categoria cat = new Categoria();
			cat.setCodigo(codca);
			ep.setCategoriaEntrada(cat);
			
			ep.setCantidad(can);
			if(codi == 0) {
				servicioEP.registrar(ep);
				redirect.addFlashAttribute("MENSAJE","Entrada de Productos Registrado");
			}else {
				pro.setCodigo(codi);
				servicioEP.actualizar(ep);
				redirect.addFlashAttribute("MENSAJE","Entrada de Productos Actualizado");
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/entradaProducto/lista";
	}	
	
	@RequestMapping("/consultaPorID")
	@ResponseBody
	public EntradaProducto consultaPorID(@RequestParam("codigo") Integer cod) {
		return servicioEP.buscarPorID(cod);
	}
	
	@RequestMapping("/eliminarPorID")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		servicioEP.eliminar(cod);
		redirect.addFlashAttribute("MENSAJE","Entrada de Producto Eliminado");
		return "redirect:/entradaProducto/lista";
	}
}
