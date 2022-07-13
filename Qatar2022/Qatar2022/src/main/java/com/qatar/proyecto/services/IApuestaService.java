package com.qatar.proyecto.services;

import java.util.List;

import com.qatar.proyecto.entities.Apuesta;
import com.qatar.proyecto.entities.Usuario;

public interface IApuestaService {
	
	public List<Apuesta> getAll();
	
	public List<Apuesta> buscarApuestasPorIdUsuario(Long id);
	
}
