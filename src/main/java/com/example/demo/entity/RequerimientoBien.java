package com.example.demo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_detalle_requerimiento")
public class RequerimientoBien {
	
	@EmbeddedId
	private RequerimientoBienPK pk;
	@ManyToOne
	@JoinColumn(name = "cod_reque",insertable = false,updatable = false,referencedColumnName ="cod_reque")
	private Requerimiento requerimiento;

	@ManyToOne
	@JoinColumn(name="id_prod",insertable = false,updatable = false,referencedColumnName = "id_prod")
	private Producto producto;
	
	@Column(name = "can")
	private int cantidad;

	public RequerimientoBienPK getPk() {
		return pk;
	}

	public void setPk(RequerimientoBienPK pk) {
		this.pk = pk;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
