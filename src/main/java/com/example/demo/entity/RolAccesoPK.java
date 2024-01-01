package com.example.demo.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class RolAccesoPK {
	private int id_rol;
	private int id_menu;
	
	@Override
	public int hashCode() {
		return Objects.hash(id_menu,id_rol);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolAccesoPK other = (RolAccesoPK) obj;
		return id_menu == other.id_menu && id_rol == other.id_rol;
	}
	
	
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	public int getId_menu() {
		return id_menu;
	}
	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}
	

}
