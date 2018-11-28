package org.carpetati.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_modelos")
public class Modelos{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Mod_Id")
	private int id;
	
	@Column(name="Mod_Nombre")
	private String nombre;
	
	@ManyToOne(targetEntity=Marcas.class, fetch=FetchType.EAGER)
	@JoinColumn(name="Marca_id")
	private Marcas marcas;

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

	public Marcas getMarcas() {
		return marcas;
	}

	public void setMarcas(Marcas marcas) {
		this.marcas = marcas;
	}

	
	
	
}
