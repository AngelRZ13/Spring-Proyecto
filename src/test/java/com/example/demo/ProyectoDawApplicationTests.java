package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.UsuarioServices;

@SpringBootTest
class ProyectoDawApplicationTests {
	@Autowired
	private UsuarioServices servicioUsu;
	
	@Autowired
	private BCryptPasswordEncoder encriptar;
	
	
	@Test
	void contextLoads() {
		System.out.println("CLAVE : "+ encriptar.encode("123"));
		
	}

}
