package org.carpetati.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respaldos")
public class Respaldos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(targetEntity = Utlmeses.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "idmes")
	private Utlmeses idmes;

	@Column
	private Date fecha;

	@Column
	private String observaciones;

	@Column
	@Lob
	private byte[] evidencia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utlmeses getIdmes() {
		return idmes;
	}

	public void setIdmes(Utlmeses idmes) {
		this.idmes = idmes;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public byte[] getEvidencia() {
		return evidencia;
	}

	public void setEvidencia(byte[] evidencia) {
		this.evidencia = evidencia;
	}

}
