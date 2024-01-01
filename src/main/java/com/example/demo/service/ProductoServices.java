package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoServices {
	
	@Autowired
	private ProductoRepository repo;
	
	public void registrar(Producto p) {
		repo.save(p);
	}
	public void actualizar(Producto p) {
		repo.save(p);
	}
	public void eliminar(Integer cod) {
		repo.deleteById(cod);;
	}
	
	public List<Producto> listarTodos(){
		return repo.findAll();
	}
	public Producto buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	} 
	
	public List<Producto> productoPorCategoria(int codCat)
	{
		return repo.listarProductosPorCategoria(codCat);
	}
	

}
