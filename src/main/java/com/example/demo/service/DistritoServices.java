package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Distrito;
import com.example.demo.repository.DistritoRepository;

@Service
public class DistritoServices {
	
	@Autowired
	private DistritoRepository repo;
	
	public List<Distrito> listarTodos(){
		return repo.findAll();
	}
}
