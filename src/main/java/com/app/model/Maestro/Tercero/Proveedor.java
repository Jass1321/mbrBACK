package com.app.model.Maestro.Tercero;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Proveedor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String codigo;
	private int ruc;
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	private String nombre;
	private String rubro;
	private String comentario;
		
	//1 tercero -> N Direccion
	@JsonIgnoreProperties("proveedor")
	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
	public Set<Direccion> direcciones = new HashSet<>();
	
	/*
	//1 tercero -> N Contacto
	@JsonIgnoreProperties("proveedor")
	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
	private Set<Contacto> contactos = new HashSet<>();
	//1 tercero -> N Cuenta
	@JsonIgnoreProperties("proveedor")
	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
	private Set<Cuenta> cuentas = new HashSet<>();
	*/
	
	public Proveedor() {
		
	}

	public Proveedor(String codigo, int ruc, Date fechaInicio, String nombre, String rubro,
			Set<Direccion> direcciones, String comentario) {
		this.codigo = codigo;
		this.ruc = ruc;
		this.fechaInicio = fechaInicio;
		this.nombre = nombre;
		this.rubro = rubro;
		this.direcciones = direcciones;
		this.comentario = comentario;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getRuc() {
		return ruc;
	}

	public void setRuc(int ruc) {
		this.ruc = ruc;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Set<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	
	
}
