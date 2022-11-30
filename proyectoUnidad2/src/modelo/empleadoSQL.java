package modelo;

import java.sql.Date;

public class empleadoSQL {
	private int id;
	private String dni;
	private String apellido;
	private Date fechaNaci;
	private Date fechaContrato;
	private String nacionalidad;
	private String cargo;
	
	public empleadoSQL(int id, String dni, String apellido, Date fechaNaci, Date fechaContrato, String nacionalidad,
			String cargo) {
		super();
		this.id = id;
		this.dni = dni;
		this.apellido = apellido;
		this.fechaNaci = fechaNaci;
		this.fechaContrato = fechaContrato;
		this.nacionalidad = nacionalidad;
		this.cargo = cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNaci() {
		return fechaNaci;
	}

	public void setFechaNaci(Date fechaNaci) {
		this.fechaNaci = fechaNaci;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
