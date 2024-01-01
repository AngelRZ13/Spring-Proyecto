package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Menu;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository repo;
	
	
	public List<Usuario> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(Usuario u) {
		repo.save(u);
	}
	
	public Usuario buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public void actualizar(Usuario u) {
		repo.save(u);
	}
	
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Usuario sesionDelUsuario(String vLogin) {
		return repo.iniciarSesion(vLogin);
	}
	
	public List<Menu> menusDelUsuario(String desRol){
		return repo.traerMenusDelUsuario(desRol);
	}
}
