package com.qatar.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qatar.proyecto.entities.Equipo;

@Repository("equipoRepository")

public interface IEquipoRepository extends JpaRepository<Equipo, Long>{
	@Query("SELECT e FROM Equipo e WHERE e.nombre = (:nombre)")
	public abstract Equipo findByNombre(@Param("nombre") String nombre); 
	
	@Query(value = "Select * FROM Equipo e WHERE e.id_equipo = (:idEquipo)", nativeQuery = true)//Creo una query porque el findById no me deja
	public abstract Equipo buscarPorId(@Param("idEquipo") Long idEquipo);
	
	@Modifying
	@Query("Update Equipo set nombre=(:nombre), direccion_imagen=(:direccionImagen) Where id_equipo=(:idEquipo)")
	public abstract int actualizarEquipo(@Param("idEquipo") Long idEquipo, @Param("direccionImagen") String direccionImagen,@Param("nombre") String nombre);
	
	
}
