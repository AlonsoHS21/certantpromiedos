package com.qatar.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qatar.proyecto.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
	@Query("Select u FROM Usuario u WHERE u.email = (:email) and u.contrasenia = (:contrasenia)")
	public abstract Usuario buscarEmailContrasenia(@Param("email") String email,@Param("contrasenia") String contrasenia);
	
	///^[a-zA-Z]+@certant\.com$/
}
