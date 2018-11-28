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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tbl_bitamov")
public class MovActivos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Bitmova_Folio")
	private int id;
	
	@Column(name="Bitmova_Fecha")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@ManyToOne(targetEntity=Cedis.class, fetch=FetchType.EAGER)
	@JoinColumn(name="Bitmova_OrigenId")
	private Cedis origen;
	
	@ManyToOne(targetEntity=Cedis.class, fetch=FetchType.EAGER)
	@JoinColumn(name="Bitmova_DestinoId")
	private Cedis destino;
	
	@Column(name="Bitmova_Activo")
	private String activo;
	
	@ManyToOne(targetEntity=Modelos.class, fetch=FetchType.EAGER)
	@JoinColumn(name="Bitmova_ModeloId")
	private Modelos modelo;
	
	@Column(name="Bitmova_Serie")
	private String serie;
	
	@Column(name="Bitmova_Motivo")
	private String motivo;
	
	@ManyToOne(targetEntity=Empleados.class, fetch=FetchType.EAGER)
	@JoinColumn(name="Bitmova_EnvioIdEmpleado")
	private Empleados empleado;
	
	@Column(name="Bitmova_Caracteristica")
	private String caracteristica;
	
	@Column(name="Bitmova_Observaciones")
	private String observaciones;
	
	@Column(name="Bitamova_Evidencia")
	@Lob
	private byte[] evidencia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cedis getOrigen() {
		return origen;
	}

	public void setOrigen(Cedis origen) {
		this.origen = origen;
	}

	public Cedis getDestino() {
		return destino;
	}

	public void setDestino(Cedis destino) {
		this.destino = destino;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Modelos getModelo() {
		return modelo;
	}

	public void setModelo(Modelos modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
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