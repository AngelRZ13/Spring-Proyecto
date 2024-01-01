package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Proveedor;
import com.example.demo.repository.ProveedorRepository;

@Service
public class ProveedorServices {

	@Autowired
	private ProveedorRepository repo;
	
	
	public List<Proveedor> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(Proveedor p) {
		repo.save(p);
	}
	
	public Proveedor buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public void actualizar(Proveedor p) {
		repo.save(p);
	}
	
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
}
