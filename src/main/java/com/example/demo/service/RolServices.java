package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Rol;
import com.example.demo.repository.RolRepository;

@Service
public class RolServices {
	
	@Autowired
	private RolRepository repo;
	
	public List<Rol> listarTodos(){
		return repo.findAll();
	}
}
