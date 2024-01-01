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
@Table(name = "rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private int codigo;
	
	@Column(name = "nom_rol")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rol")
	private List<Usuario> listaUsuarioRol;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rol")
	private List<Acceso> listaAccesoRol;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getListaUsuarioRol() {
		return listaUsuarioRol;
	}

	public void setListaUsuarioRol(List<Usuario> listaUsuarioRol) {
		this.listaUsuarioRol = listaUsuarioRol;
	}

	public List<Acceso> getListaAccesoRol() {
		return listaAccesoRol;
	}

	public void setListaAccesoRol(List<Acceso> listaAccesoRol) {
		this.listaAccesoRol = listaAccesoRol;
	}

	
	
	
}
