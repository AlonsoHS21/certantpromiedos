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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name="contrasenia")
	@NotEmpty(message = "El campo contraseña no debe estar vacio")
	private String contrasenia;
	
	@Column(name="email")
	@NotEmpty(message = "El campo email no debe estar vacio")
	@Pattern(regexp = "^[a-zA-Z]+@certant\\.com$", message = "El campo email debe contener el dominio @certant.com")
	private String email;
	
	@Column(name="puntos")
	private int puntos;
	
	@OneToMany(
			mappedBy = "usuario",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Apuesta> apuestas = new ArrayList<>();
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Jackpot jackpot;

	public Usuario() {}
	
	public Usuario(String email, String contrasenia) {
		this.email = email;
		this.contrasenia = contrasenia;
	}
	
	public Usuario(Long id, String apellido, String contrasenia, String email, String nombre, int puntos) {
		this.id = id;
		this.apellido = apellido;
		this.contrasenia = contrasenia;
		this.email = email;
		this.nombre = nombre;
		this.puntos = puntos;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public List<Apuesta> getApuestas() {
		return apuestas;
	}

	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}
	
	public Jackpot getJackpot() {
		return jackpot;
	}

	public void setJackpot(Jackpot jackpot) {
		this.jackpot = jackpot;
	}
}
