package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_menu")
	private int codigo;
	private String des_menu;
	private String url_menu;
	
	@OneToMany(mappedBy = "menu")
	private List<Acceso> listaMenuAcceso;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDes_menu() {
		return des_menu;
	}

	public void setDes_menu(String des_menu) {
		this.des_menu = des_menu;
	}

	public String getUrl_menu() {
		return url_menu;
	}

	public void setUrl_menu(String url_menu) {
		this.url_menu = url_menu;
	}

	public List<Acceso> getListaMenuAcceso() {
		return listaMenuAcceso;
	}

	public void setListaMenuAcceso(List<Acceso> listaMenuAcceso) {
		this.listaMenuAcceso = listaMenuAcceso;
	}
	
	
}
