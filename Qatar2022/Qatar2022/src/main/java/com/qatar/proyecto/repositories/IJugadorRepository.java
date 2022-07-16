package com.qatar.proyecto.repositories;

import java.util.List;

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
	
	@Query("Select j From Jugador j Where equipo_id_equipo=(:idEquipo) Order by j.apellido asc")
	public abstract List<Jugador> buscarJugadoresPorIdEquipoOrdenado(@Param("idEquipo") Long idEquipo);
	
	@Modifying
	@Query("Delete from Jugador j Where j.id=(:idJugador)")
	public abstract int eliminarJugador(@Param("idJugador") Long idJugador); 
	
	@Modifying
	@Query("Update Jugador set apellido=(:apellido), nombre=(:nombre), goles=(:goles), dorsal=(:dorsal), equipo_id_equipo=(:idEquipo) Where id_jugador=(:idJugador)")
	public abstract int actualizarJugador(@Param("apellido") String apellido, @Param("nombre") String nombre, @Param("goles") int goles,@Param("dorsal")int dorsal ,@Param("idEquipo")Long idEquipo, @Param("idJugador") Long idJugador); 

	
}
