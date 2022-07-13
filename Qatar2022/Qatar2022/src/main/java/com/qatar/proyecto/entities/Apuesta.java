package com.qatar.proyecto.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "apuesta")
public class Apuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idApuesta;
	
	@Column
	private int golesEquipo1;
	
	@Column
	private int golesEquipo2;
	
	@ManyToOne()
	@JoinColumn(name="usuario_idUsuario")	
	@NotNull
	private Usuario usuario;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_partido")
	private Partido partido;
	
	public Apuesta() {}
	
	public Long getIdApuesta() {
		return idApuesta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public int getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public void setIdApuesta(Long idApuesta) {
		this.idApuesta = idApuesta;
	}
	
}