package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.SalidaProducto;
import com.example.demo.repository.SalidaProductoRepository;

@Service
public class SalidaProductoServices {
	
	@Autowired
	private SalidaProductoRepository repo;
	
	
	public List<SalidaProducto> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(SalidaProducto sp) {
		repo.save(sp);
	}
	
	public SalidaProducto buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public void actualizar(SalidaProducto sp) {
		repo.save(sp);
	}
	
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
}
