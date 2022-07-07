package com.qatar.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qatar.proyecto.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

	
	///^[a-zA-Z]+@certant\.com$/
}
