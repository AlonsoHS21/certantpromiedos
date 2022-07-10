package com.qatar.proyecto.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "partido")
public class Partido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPartido;
	
	@Column(name = "fase")
	private String fasePartido;
	
	@Column(name = "estadio")
	private String estadio;
	
	@Column(name = "fecha")
	private Timestamp fechaPartido;
	
	@Column(name = "estado_apuesta")
	private String estadoApuesta;
	
	@OneToMany(cascade = (CascadeType.ALL))
	@JoinColumn(name = "idEquipo")
	private List<Equipo> listaEquipos = new ArrayList<Equipo>();
	
	public Partido() {}

	public Long getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}

	public String getFasePartido() {
		return fasePartido;
	}

	public void setFasePartido(String fasePartido) {
		this.fasePartido = fasePartido;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public Timestamp getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(Timestamp fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public String getEstadoApuesta() {
		return estadoApuesta;
	}

	public void setEstadoApuesta(String estadoApuesta) {
		this.estadoApuesta = estadoApuesta;
	}

	public List<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}
	
	
	
}
