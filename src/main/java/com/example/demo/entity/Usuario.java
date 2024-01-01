package com.example.demo.entity;

import java.util.List;

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
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usu")
	private int codigo;
	
	@Column(name = "log_usu")
	private String login;
	
	@Column(name = "pass_usu")
	private String pass;
	
	@Column(name = "nom_usu")
	private String nombre;
	
	@Column(name = "ape_usu")
	private String apellido;
	
	@Column(name = "sexo_usu")
	private String sexo;
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;
	
	@Column(name = "dni_usu")
	private int dni;
	
	@OneToMany(mappedBy = "usuario")
	private List<Requerimiento> listaRequerimientos;
	
	public Usuario() {
		
	}
	
	public Usuario(int codUsuario) {
		codigo=codUsuario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	
	
}
