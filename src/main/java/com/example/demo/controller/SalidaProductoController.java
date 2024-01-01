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
import com.example.demo.entity.Producto;
import com.example.demo.entity.Proveedor;
import com.example.demo.entity.SalidaProducto;
import com.example.demo.service.CategoriaServices;
import com.example.demo.service.ProductoServices;
import com.example.demo.service.ProveedorServices;
import com.example.demo.service.SalidaProductoServices;

@Controller
@RequestMapping("/salidaProducto")
public class SalidaProductoController {
	
	@Autowired
	private SalidaProductoServices servicioSP;
	
	@Autowired
	private CategoriaServices servicioCat;
	
	@Autowired
	private ProveedorServices servicioProv;
	
	@Autowired
	private ProductoServices servicioProd;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("salidaproductos", servicioSP.listarTodos());
		model.addAttribute("productos", servicioProd.listarTodos());
		model.addAttribute("proveedores", servicioProv.listarTodos());
		model.addAttribute("categorias", servicioCat.listarTodos());
		return "salidaProducto";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer codi,
						 @RequestParam("fecha") String fecha,
						 @RequestParam("productoSalida") Integer codp,
						 @RequestParam("proveedorSalida") Integer codpr,
						 @RequestParam("categoriaSalida") Integer codca,
						 @RequestParam("cantidad") int can,
						 RedirectAttributes redirect) {
		try {
			SalidaProducto ep = new SalidaProducto();
			ep.setFecha(LocalDate.parse(fecha));
			
			Producto pro = new Producto();
			pro.setCodigo(codp);
			ep.setProductoSalida(pro);
			
			Proveedor prv = new Proveedor();
			prv.setCodigo(codpr);
			ep.setProveedorSalida(prv);
			
			Categoria cat = new Categoria();
			cat.setCodigo(codca);
			ep.setCategoriaSalida(cat);
			
			ep.setCantidad(can);
			if(codi == 0) {
				servicioSP.registrar(ep);
				redirect.addFlashAttribute("MENSAJE","Salida de Productos Registrado");
			}else {
				pro.setCodigo(codi);
				servicioSP.actualizar(ep);
				redirect.addFlashAttribute("MENSAJE","Entrada de Productos Actualizado");
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/salidaProducto/lista";
	}
	
	@RequestMapping("/consultaPorID")
	@ResponseBody
	public SalidaProducto consultaPorID(@RequestParam("codigo") Integer cod) {
		return servicioSP.buscarPorID(cod);
	}
	
	@RequestMapping("/eliminarPorID")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		servicioSP.eliminar(cod);
		redirect.addFlashAttribute("MENSAJE","Salida de Producto Eliminado");
		return "redirect:/salidaProducto/lista";
	}
	
}
