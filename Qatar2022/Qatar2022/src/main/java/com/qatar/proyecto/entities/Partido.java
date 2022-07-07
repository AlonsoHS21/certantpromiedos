package com.qatar.proyecto.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
@Entity
@Table(name = "partido")
public class Partido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPartido;
	
	@Column(name = "resultado_final")
	private String resultadoFinal; //Posibles resultados 3 - 2 o guardaria al ganador
	
	@Column(name = "estado_partido")
	private String estadoPartido;
	
	@Column(name = "estadio")
	private String nombreEstadio;
	
	@Column(name = "fecha")
	private Timestamp fecha;
	
	@OneToMany
	@JoinColumn(name = "id_equipo")
	private List<Equipo> listaEquipos;
	
	public Partido() {}

	public Long getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}

	public String getResultadoFinal() {
		return resultadoFinal;
	}

	public void setResultadoFinal(String resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}

	public String getEstadoPartido() {
		return estadoPartido;
	}

	public void setEstadoPartido(String estadoPartido) {
		this.estadoPartido = estadoPartido;
	}

	public String getNombreEstadio() {
		return nombreEstadio;
	}

	public void setNombreEstadio(String nombreEstadio) {
		this.nombreEstadio = nombreEstadio;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public List<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	
}
ERROR: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is org.hibernate.DuplicateMappingException: Table [equipo] contains physical column name [id_equipo] referred to by multiple logical column names: [id_equipo], [idEquipo]

*/ 