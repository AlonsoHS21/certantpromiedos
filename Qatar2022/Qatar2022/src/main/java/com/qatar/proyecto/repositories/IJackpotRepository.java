package com.qatar.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qatar.proyecto.entities.Jackpot;

@Repository("jackpotRepository")
public interface IJackpotRepository extends JpaRepository<Jackpot, Long> {
	
	@Query("Select j From Jackpot j Where user_id=(:id)")
	public abstract Jackpot buscarJackpotPorIdUsuario(@Param("id") Long id);
	
	@Modifying
	@Query("Delete from Jackpot Where usuario_id_usuario=(:id)")
	public abstract int eliminarJackpotPorUsuario(@Param("id") Long id);


}
