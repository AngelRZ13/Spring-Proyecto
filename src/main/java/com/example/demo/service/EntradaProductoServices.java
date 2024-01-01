package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EntradaProducto;
import com.example.demo.repository.EntradaProductoRepository;


@Service
public class EntradaProductoServices {
	
	@Autowired
	private EntradaProductoRepository repo;
	
	
	public List<EntradaProducto> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(EntradaProducto ep) {
		repo.save(ep);
	}
	
	public EntradaProducto buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public void actualizar(EntradaProducto ep) {
		repo.save(ep);
	}
	
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
}
