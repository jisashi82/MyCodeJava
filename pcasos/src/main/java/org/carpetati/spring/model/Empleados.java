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
@Table(name="tbl_empleados")
public class Empleados {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Empleado_Id")
	private int id;
	
	@Column(name="Empleado_Num")
	private String numempleado;
	
	@Column(name="Empleado_Nombre")
	private String nombre;
	
	@Column(name="Empleado_Apellidos")
	private String apellidos;
	
	@Column(name="Empleado_Email")
	private String email;
	
	@Column(name="Empleado_Telefono")
	private String telefono;
	
	@ManyToOne(targetEntity=Puestos.class, fetch=FetchType.EAGER)
	@JoinColumn(name="Empleado_IdPuesto")
	private Puestos puesto;
	
	@Column(name="UserName")
	private String username;
	
	@Column(name="UserPsw")
	private  String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumempleado() {
		return numempleado;
	}

	public void setNumempleado(String numempleado) {
		this.numempleado = numempleado;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getNombres() {
		return nombre + ' '+ apellidos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Puestos getPuesto() {
		return puesto;
	}

	public void setPuesto(Puestos puesto) {
		this.puesto = puesto;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
