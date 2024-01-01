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
@Table(name="distrito")
public class Distrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_distrito")
	private Integer codigo;
	
	@Column(name = "nom_distrito")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "distrito")
	private List<Proveedor> listaDistritoProveedor;

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

	public List<Proveedor> getListaDistritoProveedor() {
		return listaDistritoProveedor;
	}

	public void setListaDistritoProveedor(List<Proveedor> listaDistritoProveedor) {
		this.listaDistritoProveedor = listaDistritoProveedor;
	}
	
	
}
