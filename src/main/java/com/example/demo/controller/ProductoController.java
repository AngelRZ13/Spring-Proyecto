package com.example.demo.controller;



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
import com.example.demo.service.CategoriaServices;
import com.example.demo.service.ProductoServices;
import com.example.demo.service.ProveedorServices;



@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoServices servicioPro;
	
	@Autowired
	private ProveedorServices servicioProve;
	
	@Autowired
	private CategoriaServices servicioCat;
	
	
	@RequestMapping("/lista")
	public String index(Model model){
		//crear atributo
		model.addAttribute("productos",servicioPro.listarTodos());
		model.addAttribute("proveedores",servicioProve.listarTodos());
		model.addAttribute("categorias",servicioCat.listarTodos());
		return "producto";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer codi,
						 @RequestParam("nombre") String nom,
						 @RequestParam("descripcion") String des,
						 @RequestParam("precio") double pre,
						 @RequestParam("proveedor") Integer codp,
						 @RequestParam("categoria") Integer cod,
						 RedirectAttributes redirect) {	
		try {
			//crear objeto de la entidad Medicamento
			Producto pro= new Producto();
			//setear atributos del objeto "med" usando los parámetros
			pro.setNombre(nom);
			pro.setDescripcion(des);
			pro.setPrecio(pre);
			//crear objeto de le entidad TipoMedicamento
			Proveedor prov=new Proveedor();
			//setear atributo codigo
			prov.setCodigo(codp);
			//enviar objeto "tp" al objeto "med"
			pro.setProveedor(prov);
			
			//---------------
			
			Categoria cat = new Categoria();
			cat.setCodigo(cod);
			pro.setCategoria(cat);
			
			
			//validar codi
			if(codi==0) {
				//invocar al método registrar
				servicioPro.registrar(pro);
				//mensaje +
				redirect.addFlashAttribute("MENSAJE","Producto registrado");
			}
			else {
				//setear atributo codigo
				pro.setCodigo(codi);
				servicioPro.actualizar(pro);
				//mensaje +
				redirect.addFlashAttribute("MENSAJE","Producto actualizado");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/producto/lista";
	}
	
	@RequestMapping("/consultaPorID")
	@ResponseBody
	public Producto consultaPorID(@RequestParam("codigo") Integer cod){
		return servicioPro.buscarPorID(cod);
	}
	
	@RequestMapping("/eliminarPorID")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		servicioPro.eliminar(cod);
		redirect.addFlashAttribute("MENSAJE","Producto eliminado");
		return "redirect:/producto/lista";
	}
	

}
