package com.qatar.proyecto.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.qatar.proyecto.entities.Equipo;

public interface IEquipoService {
	
	public List<Equipo> getAll();

	public Equipo buscar(String nombre);

	public int eliminar(Long id);
	
	public void save(Equipo equipo);
	
	public Equipo findByNombre(@Param("nombre") String nombre);
	
	public Equipo buscarPorId(Long id);
	
	public Double calculateTotal(Equipo equipo);
	
	public int actualizarEquipo(Long idEquipo, String direccionImagen, String nombre );
	
	public int guardarEquipo(String nombre, String direccionImagen);
}
