package com.qatar.proyecto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "jugador")
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idJugador;
	
	@Column(name = "nombre")
	@NotEmpty(message="El campo nombre no debe esta vacio")
	private String nombre;
	
	@Column(name = "apellido")
	@NotEmpty(message="El campo apellido no debe estar vacio")
	private String apellido;
	
	@Column(name = "goles") //Puede estar vacio empieza en 0
	private int goles;
	
	@Column
	@NotNull(message="El campo dorsal no debe estar vacio")
	@Min( value = 1, message = "El numero del dorsal no puede ser menor a 1")
	@Max ( value = 30, message = "El numero del dorsal no puede ser mayor a 30")
	private int dorsal;
	
	@ManyToOne()
	@JoinColumn(name="equipo_idEquipo")
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

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

}