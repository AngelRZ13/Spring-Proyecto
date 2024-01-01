package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.demo.entity.Rol;
import com.example.demo.entity.Usuario;
import com.example.demo.service.RolServices;
import com.example.demo.service.UsuarioServices;

@Controller
@RequestMapping("/usuario")
public class UsuarioCrudController {
	
	
	@Autowired
	private UsuarioServices servicioUsu;
	
	@Autowired
	private RolServices servicioRol;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("usuarios",servicioUsu.listarTodos());
		model.addAttribute("roles",servicioRol.listarTodos());
		return "usuario";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer codi,
						 @RequestParam("login") String log,
						 @RequestParam("pass") String pass,
						 @RequestParam("nombre") String nom,
						 @RequestParam("apellido") String ape,
						 @RequestParam("sexo") String sexo,
						 @RequestParam("rol") Integer cod,
						 @RequestParam("dni") int dni,
						 RedirectAttributes redirect) {
		try {
			Usuario usu = new Usuario();
			usu.setLogin(log);
			usu.setPass(pass);
			usu.setNombre(nom);
			usu.setApellido(ape);
			usu.setSexo(sexo);
		
			Rol rol = new Rol();
			rol.setCodigo(cod);
			usu.setRol(rol);
			
			usu.setDni(dni);
			
			if(codi == 0) {
				servicioUsu.registrar(usu);
				redirect.addFlashAttribute("MENSAJE","Usuario Registrado");
			}else {
				usu.setCodigo(codi);
				servicioUsu.actualizar(usu);
				redirect.addFlashAttribute("MENSAJE","Usuario Actualizado");
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/usuario/lista";
	}	
	
	@RequestMapping("/consultaPorID")
	@ResponseBody
	public Usuario consultaPorID(@RequestParam("codigo") Integer cod) {
		return servicioUsu.buscarPorID(cod);
	}
	
	@RequestMapping("/eliminarPorID")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		servicioUsu.eliminar(cod);
		redirect.addFlashAttribute("MENSAJE","Usuario Eliminado");
		return "redirect:/usuario/lista";
	}
}
