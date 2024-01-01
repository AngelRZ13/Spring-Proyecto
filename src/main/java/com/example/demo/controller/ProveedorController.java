package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Distrito;
import com.example.demo.entity.Proveedor;
import com.example.demo.service.DistritoServices;
import com.example.demo.service.ProveedorServices;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorServices servicioProv;
	
	@Autowired
	private DistritoServices servicioDis;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("proveedores",servicioProv.listarTodos());
		model.addAttribute("distritos",servicioDis.listarTodos());
		return "proveedor";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer codi,
						 @RequestParam("nombre") String nom,
						 @RequestParam("ruc") String ruc,
						 @RequestParam("direccion") String dir,
						 @RequestParam("telefono") int tel,
						 @RequestParam("email") String ema,
						 @RequestParam("distrito") Integer cod,
						 RedirectAttributes redirect) {
		try {
			Proveedor pro = new Proveedor();
			pro.setNombre(nom);
			pro.setRuc(ruc);
			pro.setDireccion(dir);
			pro.setTelefono(tel);
			pro.setEmail(ema);
		
			Distrito dis = new Distrito();
			dis.setCodigo(cod);
			pro.setDistrito(dis);
			if(codi == 0) {
				servicioProv.registrar(pro);
				redirect.addFlashAttribute("MENSAJE","Proveedor Registrado");
			}else {
				pro.setCodigo(codi);
				servicioProv.actualizar(pro);
				redirect.addFlashAttribute("MENSAJE","Proveedor Actualizado");
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/proveedor/lista";
	}	
	
	@RequestMapping("/consultaPorID")
	@ResponseBody
	public Proveedor consultaPorID(@RequestParam("codigo") Integer cod) {
		return servicioProv.buscarPorID(cod);
	}
	
	@RequestMapping("/eliminarPorID")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		servicioProv.eliminar(cod);
		redirect.addFlashAttribute("MENSAJE","Proveedor Eliminado");
		return "redirect:/proveedor/lista";
	}
}
