package com.qatar.proyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qatar.proyecto.entities.Apuesta;

@Repository("apuestaRepository")
public interface IApuestaRepository extends JpaRepository<Apuesta, Long>{
	
	@Query("Select a From Apuesta a Where usuario_id_usuario=(:id)")
	public abstract List<Apuesta> buscarApuestasPorIdUsuario(@Param("id") Long id);

}
