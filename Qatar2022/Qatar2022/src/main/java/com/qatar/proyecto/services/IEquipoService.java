package com.qatar.proyecto.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.qatar.proyecto.entities.Equipo;

public interface IEquipoService {
	
	public List<Equipo> getAll();

	public Equipo buscar(long id);

	public void eliminar(long id);
	
	public void save(Equipo equipo);
	
	public Equipo findByNombre(@Param("nombre") String nombre);

	
	public Double calculateTotal(Equipo equipo);

}
