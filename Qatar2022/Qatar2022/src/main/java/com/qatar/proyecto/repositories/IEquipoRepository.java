package com.qatar.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qatar.proyecto.entities.Equipo;

@Repository("equipoRepository")
public interface IEquipoRepository extends JpaRepository<Equipo, Long>{
	@Query("SELECT e FROM Equipo e WHERE e.nombre = (:nombre)")
	public abstract Equipo findByNombre(@Param("nombre") String nombre); 

}
