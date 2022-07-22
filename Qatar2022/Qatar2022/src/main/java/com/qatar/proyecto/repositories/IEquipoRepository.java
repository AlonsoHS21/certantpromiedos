package com.qatar.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qatar.proyecto.entities.Equipo;

@Repository("equipoRepository")

public interface IEquipoRepository extends JpaRepository<Equipo, Long>{
	
	@Query("SELECT e FROM Equipo e WHERE e.nombre LIKE CONCAT('%',(:nombre),'%')")
	public abstract Equipo findByNombre(@Param("nombre") String nombre); 
	
	@Query(value = "Select * FROM Equipo e WHERE e.id_equipo = (:idEquipo)", nativeQuery = true)
	public abstract Equipo buscarPorId(@Param("idEquipo") Long idEquipo);
	
	@Modifying
	@Transactional
	@Query("Update Equipo set nombre=(:nombre), direccion_imagen=(:direccionImagen) Where id_equipo=(:idEquipo)")
	public abstract int actualizarEquipo(@Param("idEquipo") Long idEquipo, @Param("direccionImagen") String direccionImagen,@Param("nombre") String nombre);
	
	@Modifying
	@Transactional
	@Query("Delete from Equipo u Where u.id=(:id)")
	public abstract int eliminarEquipo(@Param("id") Long id);
	
	@Modifying
	@Query( value = "insert into Equipo (direccion_imagen, nombre) values (:direccionImagen, :nombre)" , nativeQuery = true)
	public abstract int guardarEquipo(@Param("nombre") String nombre, @Param("direccionImagen") String direccionImagen);
	
}
