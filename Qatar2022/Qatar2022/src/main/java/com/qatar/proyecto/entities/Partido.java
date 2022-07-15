package com.qatar.proyecto.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "partido")
public class Partido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPartido;
	
	@Column(name = "fase")
	private String fasePartido;
	
	@Column(name = "estadio")
	@NotEmpty(message = "El campo estadio no puede estar vacio")
	private String estadio;
	
	@Column(name = "fecha")
	private String fechaPartido;
	
	@Column(name = "estado_apuesta")
	private String estadoApuesta;
	
	@Column(name = "idequipo_local")
	private Long idEquipoLocal;
	
	@Column(name="resultadoEquipoLocal")
	private int resultaEquipoLocal;
	
	@Column(name = "idequipo_visitante")
	private Long idEquipoVisitante;
	
	@Column(name="resultadoEquipoVisitante")
	private int resultadoEquipoVisitante;
	
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

	public String getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(String fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public String getEstadoApuesta() {
		return estadoApuesta;
	}

	public void setEstadoApuesta(String estadoApuesta) {
		this.estadoApuesta = estadoApuesta;
	}

	public Long getIdEquipoLocal() {
		return idEquipoLocal;
	}

	public void setIdEquipoLocal(Long idEquipoLocal) {
		this.idEquipoLocal = idEquipoLocal;
	}

	public Long getIdEquipoVisitante() {
		return idEquipoVisitante;
	}

	public void setIdEquipoVisitante(Long idEquipoVisitante) {
		this.idEquipoVisitante = idEquipoVisitante;
	}

	public int getResultaEquipoLocal() {
		return resultaEquipoLocal;
	}

	public void setResultaEquipoLocal(int resultaEquipoLocal) {
		this.resultaEquipoLocal = resultaEquipoLocal;
	}

	public int getResultadoEquipoVisitante() {
		return resultadoEquipoVisitante;
	}

	public void setResultadoEquipoVisitante(int resultadoEquipoVisitante) {
		this.resultadoEquipoVisitante = resultadoEquipoVisitante;
	}
	
}
