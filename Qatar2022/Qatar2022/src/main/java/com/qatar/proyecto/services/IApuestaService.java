package com.qatar.proyecto.services;

import java.util.List;

import com.qatar.proyecto.entities.Apuesta;

public interface IApuestaService {
	
	public List<Apuesta> getAll();
	
	public List<Apuesta> buscarApuestasPorIdUsuario(Long id);
	
	public void save(Apuesta apuesta);
	
	public int eliminarApuestasPorUsuario(Long id);
	
}
