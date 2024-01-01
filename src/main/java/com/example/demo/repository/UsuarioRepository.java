package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Menu;
import com.example.demo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("select u from Usuario u where u.login=?1")
	public Usuario iniciarSesion(String vLogin);
	
	@Query("select e from Acceso ac join ac.menu e where ac.rol.nombre=?1")
	public List<Menu> traerMenusDelUsuario(String desRol);
}
