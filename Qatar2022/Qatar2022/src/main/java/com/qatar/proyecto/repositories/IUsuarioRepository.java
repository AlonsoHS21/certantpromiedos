package com.qatar.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qatar.proyecto.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
	@Query("Select u FROM Usuario u WHERE u.email = (:email) and u.contrasenia = (:contrasenia)")
	public abstract Usuario buscarEmailContrasenia(@Param("email") String email,@Param("contrasenia") String contrasenia);
	
	@Query("Select u FROM Usuario u WHERE u.id = (:id)")//Creo una query porque el findById no me deja
	public abstract Usuario buscarPorId(@Param("id") Long id);
	
	@Modifying
	@Query("Update Usuario set contrasenia=(:contrasenia) WHERE id=(:id)")
	public abstract int actualizarUsuario(@Param("contrasenia") String contrasenia,@Param("id") Long id);
	
	@Modifying
	@Query("Delete from Usuario u Where u.id=(:id)")
	public abstract int eliminarUsuario(@Param("id") Long id); 
	
	@Query("Select u FROM Usuario u Where u.email=(:email)")
	public abstract Usuario buscarUsuarioPorEmail(@Param("email") String email);
	
	///^[a-zA-Z]+@certant\.com$/
}
