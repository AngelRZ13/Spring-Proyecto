package com.example.demo.entity;

import java.util.Objects;

import com.example.demo.entity.RequerimientoBienPK;

import jakarta.persistence.Embeddable;

@Embeddable
public class RequerimientoBienPK {
	private int cod_reque;
	private int id_prod;
	
	@Override
	public int hashCode() {
		return Objects.hash(id_prod, cod_reque);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequerimientoBienPK other = (RequerimientoBienPK) obj;
		return id_prod == other.id_prod && cod_reque == other.cod_reque;
	}

	public int getCod_reque() {
		return cod_reque;
	}

	public void setCod_reque(int cod_reque) {
		this.cod_reque = cod_reque;
	}

	public int getCod_bien() {
		return id_prod;
	}

	public void setCod_bien(int cod_prod) {
		this.id_prod = cod_prod;
	}
	
	
}
