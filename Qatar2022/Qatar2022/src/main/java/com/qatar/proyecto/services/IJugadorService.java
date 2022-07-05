package com.qatar.proyecto.services;

import java.util.List;

import com.qatar.proyecto.entities.Jugador;

public interface IJugadorService {
	
	public List<Jugador> getAll();

	public Jugador buscar(long id);

	public void eliminar(long id);
	
	public void save(Jugador jugador);

}
