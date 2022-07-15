package com.qatar.proyecto.services;

import java.util.List;

import com.qatar.proyecto.entities.Partido;

public interface IPartidoService {
	
	public List<Partido> getAll();
	
	public void save(Partido partido);
	
	public void eliminar(Long idPartido);
	
	public Partido findById(Long idPartido);
	
	public int actualizarPartido(String estadio, String estadoApuesta, String fasePartido,String fechaPartido, Long equipoLocal, Long equipoVisitante,int resultadoEquipoLocal, int resultadoEquipoVisitante, Long idPartido);

	public int cargarResultadoPartido(int resultadoEquipoLocal, int resultadoEquipoVisitante, Long idPartido);
}
