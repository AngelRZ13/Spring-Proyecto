package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_entrada")
public class EntradaProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ep")
	private Integer codigo;
	
	@Column(name = "fecha_ep")
	private LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name = "id_prod")
	private Producto productoEntrada;
	
	@ManyToOne
	@JoinColumn(name = "id_prov")
	private Proveedor proveedorEntrada;
	
	@ManyToOne
	@JoinColumn(name = "id_cat")
	private Categoria categoriaEntrada;
	
	@Column(name = "cant_ep")
	private int cantidad;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Producto getProductoEntrada() {
		return productoEntrada;
	}

	public void setProductoEntrada(Producto productoEntrada) {
		this.productoEntrada = productoEntrada;
	}

	public Proveedor getProveedorEntrada() {
		return proveedorEntrada;
	}

	public void setProveedorEntrada(Proveedor proveedorEntrada) {
		this.proveedorEntrada = proveedorEntrada;
	}

	public Categoria getCategoriaEntrada() {
		return categoriaEntrada;
	}

	public void setCategoriaEntrada(Categoria categoriaEntrada) {
		this.categoriaEntrada = categoriaEntrada;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
	
	
}
