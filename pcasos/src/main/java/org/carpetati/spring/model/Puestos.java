package org.carpetati.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_puestos")
public class Puestos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Puesto_Id")
	private int id;
	
	@Column(name="Puesto_Nombre")
	private String nombre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}