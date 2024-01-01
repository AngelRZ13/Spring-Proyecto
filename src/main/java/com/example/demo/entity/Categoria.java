package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cat")
	private Integer codigo;
	
	@Column(name = "nom_cat")
	private String nombre;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<Producto> listaCategoriaProducto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoriaEntrada")
	private List<EntradaProducto> listaCategoriaEntrada;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoriaSalida")
	private List<SalidaProducto> listaCategoriaSalida;

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


	public List<Producto> getListaCategoriaProducto() {
		return listaCategoriaProducto;
	}


	public void setListaCategoriaProducto(List<Producto> listaCategoriaProducto) {
		this.listaCategoriaProducto = listaCategoriaProducto;
	}


	public List<EntradaProducto> getListaCategoriaEntrada() {
		return listaCategoriaEntrada;
	}


	public void setListaCategoriaEntrada(List<EntradaProducto> listaCategoriaEntrada) {
		this.listaCategoriaEntrada = listaCategoriaEntrada;
	}


	public List<SalidaProducto> getListaCategoriaSalida() {
		return listaCategoriaSalida;
	}


	public void setListaCategoriaSalida(List<SalidaProducto> listaCategoriaSalida) {
		this.listaCategoriaSalida = listaCategoriaSalida;
	}


	
	
	
	
}
