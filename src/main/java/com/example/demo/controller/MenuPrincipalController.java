package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuPrincipalController {
	
	@RequestMapping("/MenuPrincipal")
	public String MenuPrincipal() {
		return "MenuPrincipal";
	}
	
	@RequestMapping("/Login")
	public String login(){
		return "Login";
	}
}
