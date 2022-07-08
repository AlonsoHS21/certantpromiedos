package com.qatar.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qatar.proyecto.entities.Jugador;

@Repository("jugadorRepository")
public interface IJugadorRepository extends JpaRepository<Jugador, Long>{
	
	@Query("Select j From Jugador j Where j.id=(:idJugador)")
	public abstract Jugador buscarJugadorPorId(@Param("idJugador") Long idJugador);
	
	@Modifying
	@Query("Delete from Jugador j Where j.id=(:idJugador)")
	public abstract int eliminarJugador(@Param("idJugador") Long idJugador); 

}
