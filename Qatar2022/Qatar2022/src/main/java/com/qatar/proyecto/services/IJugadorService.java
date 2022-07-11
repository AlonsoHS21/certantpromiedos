package com.qatar.proyecto.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.qatar.proyecto.entities.Jugador;

public interface IJugadorService {
	
	public List<Jugador> getAll();

	public Jugador buscar(Long id);

	public int eliminarJugador(Long id);
	
	public void save(Jugador jugador);
	
	public int actualizarJugador(String apellido, String nombre, int goles, Long idEquipo, Long idJugador);

}
