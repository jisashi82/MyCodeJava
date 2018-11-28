package org.carpetati.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="bitareparacion")
public class Reparacion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdFolio")
	private int id;
	
	
	//@NotEmpty(message="Se requiere la serie del equipo")
	@Column(name="Serie")
	private String serie;
	
	@ManyToOne(targetEntity=Modelos.class, fetch=FetchType.EAGER)
	@JoinColumn(name="Mod_Id")
	private Modelos modelo;
	
	@ManyToOne(targetEntity=Cedis.class, fetch=FetchType.EAGER)
	@JoinColumn(name="Ced_Id")
	private Cedis cedis;
	
	@ManyToOne(targetEntity=Empleados.class, fetch=FetchType.EAGER)
	@JoinColumn(name="Empleado_Id")
	private Empleados empleado;
	
	@Column(name="FallaDetalle", columnDefinition="Text")
	private String falla;
	
	@ManyToOne(targetEntity=Status.class)
	@JoinColumn(name="IdTipoproblema")
	private Status tipoproblema;
	
	@ManyToOne(targetEntity=Status.class)
	@JoinColumn(name="Id_Status_Acta")
	private Status acta;
	
	@ManyToOne(targetEntity=Status.class)
	@JoinColumn(name="Id_Status_Descuento")
	private Status descuento;
	
	@Column(name="Fec_Envio")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecenvio;
	
	@Column(name="Fec_Retorno")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecretorno;
	
	@ManyToOne(targetEntity=Status.class)
	@JoinColumn(name="Id_Status")
	private Status status;
	
	@Column(name="Observaciones")
	private String observaciones;
	
	@Column(name="Fec_Initramite")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecinitramite;
	
	@Column(name="Ro", length=15)
	private String ro;

	public int getId() { return id;	}
	public void setId(int id) {	this.id = id; }

	public String getSerie() {	return serie; }
	public void setSerie(String serie) { this.serie = serie; }

	public Modelos getModelo() { return modelo;	}
	public void setModelo(Modelos modelo) {	this.modelo = modelo; }

	public Cedis getCedis() { return cedis;	}
	public void setCedis(Cedis cedis) {	this.cedis = cedis;	}

	public Empleados getEmpleado() { return empleado; }
	public void setEmpleado(Empleados empleado) { this.empleado = empleado; }

	public String getFalla() {	return falla; }
	public void setFalla(String falla) { this.falla = falla; }

	public Status getTipoproblema() {return tipoproblema;}
	public void setTipoproblema(Status tipoproblema) {	this.tipoproblema = tipoproblema;}

	public Status getActa() {return acta;}
	public void setActa(Status acta) {this.acta = acta;	}

	public Status getDescuento() {	return descuento; }
	public void setDescuento(Status descuento) {this.descuento = descuento;	}

	public Date getFecenvio() {	return fecenvio; }
	public void setFecenvio(Date fecenvio) { this.fecenvio = fecenvio;	}

	public Date getFecretorno() { return fecretorno; }
	public void setFecretorno(Date fecretorno) { this.fecretorno = fecretorno;	}

	public Status getStatus() {	return status;	}
	public void setStatus(Status status) {	this.status = status; }

	public String getObservaciones() {	return observaciones;}
	public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

	public Date getFecinitramite() { return fecinitramite; }
	public void setFecinitramite(Date fecinitramite) {	this.fecinitramite = fecinitramite;	}

	public String getRo() {	return ro; }
	public void setRo(String ro) {	this.ro = ro;	}	
	
}