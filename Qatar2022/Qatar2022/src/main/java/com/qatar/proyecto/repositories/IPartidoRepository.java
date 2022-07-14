package com.qatar.proyecto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qatar.proyecto.entities.Partido;

@Repository("partidoRepository")
public interface IPartidoRepository extends JpaRepository<Partido, Long>{
	
	@Query(value="Select * from Partido p Where p.id_partido=(:idPartido)", nativeQuery=true)
	public abstract Partido buscarPartidoPorId(@Param("idPartido") Long idPartido);
	
	@Modifying
	@Query("Update Partido set estadio=(:estadio), estado_apuesta=(:estadoApuesta),fase=(:fasePartido),fecha=(:fechaPartido), idequipo_local=(:idEquipoLocal), idequipo_visitante=(:idEquipoVisitante) Where id_partido=(:idPartido) ")
	public abstract int actualizarPartido(@Param("estadio")String estadio,@Param("estadoApuesta") String estadoApuesta,@Param("fasePartido") String fasePartido,@Param("fechaPartido") String fechaPartido,@Param("idEquipoLocal") Long equipoLocal,@Param("idEquipoVisitante") Long equipoVisitante,@Param("idPartido") Long idPartido); 
}
