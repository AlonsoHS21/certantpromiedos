package com.qatar.proyecto.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "equipo")
public class Equipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipo;
	
	@Column(name = "nombre")
	@NotEmpty(message = "El campo nombre de equipo no debe estar vacio")
	private String nombre;
	
	@Column(name = "direccionImagen")
	private String direccionImagen; 
	
	@OneToMany(
			mappedBy = "equipo",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Jugador> jugadores = new ArrayList<>();
	
	public Equipo() {}
	
	public Equipo(Long idEquipo, String nombre) {
		this.idEquipo = idEquipo;
		this.nombre = nombre;
	}

	public Equipo(String nombre, String direccionImagen) {
		super();
		this.nombre = nombre;
		this.direccionImagen = direccionImagen;
	}
	
	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}
	
	public long getIdEquipo() {
		return idEquipo;
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
	
	public List<Jugador> getJugador() {
		return jugadores;
	}

	public void setJugador(List<Jugador> jugador) {
		this.jugadores = jugador;
	}
	
}

