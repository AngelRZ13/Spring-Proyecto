package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.entity.Menu;
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioServices;

@SessionAttributes({"ENLACES","CODIGOUSUARIO","DATOSUSUARIO","ROLUSUARIO"})

@Controller
@RequestMapping("/sesion")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioServices servicioUsu;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/intranet")
	public String intranet(Authentication auth, Model model) {
		
		String nomRol=auth.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));
		List<Menu> lista=servicioUsu.menusDelUsuario(nomRol);
		Usuario usu = servicioUsu.sesionDelUsuario(auth.getName());
		model.addAttribute("ENLACES",lista);
		model.addAttribute("CODIGOUSUARIO",usu.getCodigo());
		model.addAttribute("DATOSUSUARIO",usu.getApellido()+ " "+usu.getNombre());
		model.addAttribute("ROLUSUARIO",nomRol);
		return "intranet";
	}
	
}
