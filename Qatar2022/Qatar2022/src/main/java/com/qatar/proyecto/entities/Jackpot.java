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

@Entity
@Table(name = "jackpot")
public class Jackpot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idJackpot;

	@Column(name = "idCampeon")
	private int idCampeon;
	
	@Column(name = "idGoleador")
	private int idGoleador;
	
	@OneToMany(
			mappedBy = "jackpot",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Usuario> usuarios = new ArrayList<>();
	
	public Jackpot() {}

	public Long getIdJackpot() {
		return idJackpot;
	}

	public void setIdJackpot(Long idJackpot) {
		this.idJackpot = idJackpot;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
