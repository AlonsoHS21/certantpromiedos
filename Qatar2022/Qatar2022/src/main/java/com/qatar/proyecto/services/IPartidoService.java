package com.qatar.proyecto.services;

import java.util.List;

import com.qatar.proyecto.entities.Partido;

public interface IPartidoService {
	
	public List<Partido> getAll();
	
	public void save(Partido partido);
	
	public void eliminar(Long idPartido);
}
