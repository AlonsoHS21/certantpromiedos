package com.qatar.proyecto.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Usuario usuario;
	
	public Jackpot() {}

	public Long getIdJackpot() {
		return idJackpot;
	}

	public void setIdJackpot(Long idJackpot) {
		this.idJackpot = idJackpot;
	}

	public int getIdCampeon() {
		return idCampeon;
	}

	public void setIdCampeon(int idCampeon) {
		this.idCampeon = idCampeon;
	}

	public int getIdGoleador() {
		return idGoleador;
	}

	public void setIdGoleador(int idGoleador) {
		this.idGoleador = idGoleador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
