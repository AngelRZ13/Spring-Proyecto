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
@Table(name = "producto_salida")
public class SalidaProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sp")
	private Integer codigo;
	
	@Column(name = "fecha_sp")
	private LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name = "id_prod")
	private Producto productoSalida;
	
	@ManyToOne
	@JoinColumn(name = "id_prov")
	private Proveedor proveedorSalida;
	
	@ManyToOne
	@JoinColumn(name = "id_cat")
	private Categoria categoriaSalida;
	
	@Column(name = "cant_sp")
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

	public Producto getProductoSalida() {
		return productoSalida;
	}

	public void setProductoSalida(Producto productoSalida) {
		this.productoSalida = productoSalida;
	}

	public Proveedor getProveedorSalida() {
		return proveedorSalida;
	}

	public void setProveedorSalida(Proveedor proveedorSalida) {
		this.proveedorSalida = proveedorSalida;
	}

	public Categoria getCategoriaSalida() {
		return categoriaSalida;
	}

	public void setCategoriaSalida(Categoria categoriaSalida) {
		this.categoriaSalida = categoriaSalida;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	

	
	
	
}
