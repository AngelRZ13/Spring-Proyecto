package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prod")
	private Integer codigo;
	
	@Column(name = "nom_prod")
	private String nombre;
	
	@Column(name = "descrip_prod")
	private String descripcion;
	
	@Column(name = "precio_prod")
	private double precio;
	
	@ManyToOne
	@JoinColumn(name = "id_prov")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "id_cat")
	private Categoria categoria;
	
	@JsonIgnore
	@OneToMany(mappedBy = "productoEntrada")
	private List<EntradaProducto> listaProductoEntrada;
	
	@JsonIgnore
	@OneToMany(mappedBy = "productoSalida")
	private List<SalidaProducto> listaProductoSalida;
	
	@JsonIgnore
	@OneToMany(mappedBy = "producto")
	private List<RequerimientoBien> listaRequerimientos;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<EntradaProducto> getListaProductoEntrada() {
		return listaProductoEntrada;
	}

	public void setListaProductoEntrada(List<EntradaProducto> listaProductoEntrada) {
		this.listaProductoEntrada = listaProductoEntrada;
	}

	public List<SalidaProducto> getListaProductoSalida() {
		return listaProductoSalida;
	}

	public void setListaProductoSalida(List<SalidaProducto> listaProductoSalida) {
		this.listaProductoSalida = listaProductoSalida;
	}
	
	
	
}
