package com.example.demo.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioServices;

public class UserServices implements UserDetailsService{
	@Autowired
	private UsuarioServices servicioUsu;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		UserDetails bean=null;
		Usuario usu=servicioUsu.sesionDelUsuario(username);
		Set<GrantedAuthority> rol = new HashSet<GrantedAuthority>();
		rol.add(new SimpleGrantedAuthority(usu.getRol().getNombre()));
		bean=new User(username, usu.getPass(), rol);
		
		return bean;
	}

}
