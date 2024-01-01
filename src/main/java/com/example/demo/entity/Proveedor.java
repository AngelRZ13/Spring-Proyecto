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
@Table(name = "proveedor")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prov")
	private Integer codigo;
	
	@Column(name = "nom_prov")
	private String nombre;
	
	@Column(name = "ruc_prov")
	private String ruc;
	
	@Column(name = "dir_prov")
	private String direccion;
	
	@Column(name = "tel_prov")
	private int telefono;
	
	@Column(name = "email_prov")
	private String email;
	
	
	@ManyToOne
	@JoinColumn(name = "cod_distrito")
	private Distrito distrito;

	@JsonIgnore
	@OneToMany(mappedBy = "proveedor")
	private List<Producto> listaProveedorProducto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proveedorEntrada")
	private List<EntradaProducto> listaProveedorEntrada;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proveedorSalida")
	private List<SalidaProducto> listaProveedorSalida;
	
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


	public String getRuc() {
		return ruc;
	}


	public void setRuc(String ruc) {
		this.ruc = ruc;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Distrito getDistrito() {
		return distrito;
	}


	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}


	public List<Producto> getListaProveedorProducto() {
		return listaProveedorProducto;
	}


	public void setListaProveedorProducto(List<Producto> listaProveedorProducto) {
		this.listaProveedorProducto = listaProveedorProducto;
	}


	public List<EntradaProducto> getListaProveedorEntrada() {
		return listaProveedorEntrada;
	}


	public void setListaProveedorEntrada(List<EntradaProducto> listaProveedorEntrada) {
		this.listaProveedorEntrada = listaProveedorEntrada;
	}


	public List<SalidaProducto> getListaProveedorSalida() {
		return listaProveedorSalida;
	}


	public void setListaProveedorSalida(List<SalidaProducto> listaProveedorSalida) {
		this.listaProveedorSalida = listaProveedorSalida;
	}

	
	
	
	
	
	
}
