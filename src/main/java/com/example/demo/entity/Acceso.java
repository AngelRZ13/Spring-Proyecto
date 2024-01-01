package com.example.demo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "acceso")
public class Acceso {
	
	@EmbeddedId
	private RolAccesoPK pk;
	
	@ManyToOne
	@JoinColumn(name = "id_rol", insertable = false,updatable = false,referencedColumnName = "id_rol")
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "id_menu", insertable = false, updatable = false,referencedColumnName = "id_menu")
	private Menu menu;

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public RolAccesoPK getPk() {
		return pk;
	}

	public void setPk(RolAccesoPK pk) {
		this.pk = pk;
	}

	
	
}
