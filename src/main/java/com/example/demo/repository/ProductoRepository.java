package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	@Query("select p from Producto p where p.categoria.codigo=?1")
	List<Producto> listarProductosPorCategoria(int codCat);
	
	
}
