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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "jugador")
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idJugador;
	
	@Column(name = "nombre")
	@NotEmpty(message="El nombre no debe estar vacio")
	private String nombre;
	
	@Column(name = "apellido")
	@NotEmpty(message="El apellido no debe estar vacio")
	private String apellido;
	
	@Column(name = "goles")
	private int goles;
	
	@ManyToOne
	@JoinColumn(name="equipo_idEquipo")	
	@NotNull
	private Equipo equipo;
	
	 public Jugador() {
	    	
	    }

	public Jugador(String nombre,String apellido, Equipo equipo, int goles) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.equipo = equipo;
		this.goles = goles;
	}

	public long getIdJugador() {
		return idJugador;
	}

	protected void setIdJugador(long idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}
	
}

