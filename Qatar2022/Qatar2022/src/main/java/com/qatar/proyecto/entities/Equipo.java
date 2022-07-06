package com.qatar.proyecto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "equipo")
public class Equipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEquipo;
	
	@Column(name = "nombre")
	@NotEmpty(message="El nombre no debe estar vacio")
	private String nombre;
	
	@Column(name = "direccionImagen")
	private String direccionImagen; //Por ahora recibe una url de la imagen
	
	@Column(name = "scoreTotal")
	private Long cantidadTotalGoles;
	
	 public Equipo() {
	    	
	    }

	public Equipo(String nombre, String direccionImagen, Long cantidadTotalGoles) {
		super();
		this.nombre = nombre;
		this.direccionImagen = direccionImagen;
		this.cantidadTotalGoles = cantidadTotalGoles;
		
	}

	public long getIdEquipo() {
		return idEquipo;
	}

	protected void setIdEquipo(long idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccionImagen() {
		return direccionImagen;
	}

	public void setDireccionImagen(String direccionImagen) {
		this.direccionImagen = direccionImagen;
	}

	public Long getCantidadTotalGoles() {
		return cantidadTotalGoles;
	}

	public void setCantidadTotalGoles(Long cantidadTotalGoles) {
		this.cantidadTotalGoles = cantidadTotalGoles;
	}

}

