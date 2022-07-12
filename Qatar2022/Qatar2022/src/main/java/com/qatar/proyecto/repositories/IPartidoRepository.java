package com.qatar.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qatar.proyecto.entities.Partido;

@Repository("partidoRepository")
public interface IPartidoRepository extends JpaRepository<Partido, Long>{
	
}
