package com.qatar.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qatar.proyecto.entities.Jugador;

@Repository("jugadorRepository")
public interface IJugadorRepository extends JpaRepository<Jugador, Long>{

}
