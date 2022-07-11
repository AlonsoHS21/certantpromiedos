package com.qatar.proyecto.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.repositories.IEquipoRepository;
import com.qatar.proyecto.services.IEquipoService;

@Service("equipoService")
public class EquipoService implements IEquipoService{
	
	@Autowired
	@Qualifier("equipoRepository")
	private IEquipoRepository equipoRepository;

	@Override
	public List<Equipo> getAll() {
		return equipoRepository.findAll();
	}

	@Override
	public Equipo buscar(String nombre) {
		return equipoRepository.findByNombre(nombre);
	}

	@Override
	@Transactional
	public void save(Equipo equipo) {
		equipoRepository.save(equipo);
	}

	@Override
	public Double calculateTotal(Equipo equipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipo findByNombre(@Param("nombre")String nombre) {
		return equipoRepository.findByNombre(nombre);
	}

	@Override
	public Equipo buscarPorId(Long id) {
		return equipoRepository.buscarPorId(id);
	}

	@Override
	@Transactional
	public int eliminar(Long id) {
		//return equipoRepository.eliminarEquipo(id);
		return 0;
	}

	@Override
	@Transactional
	public int actualizarEquipo(Long idEquipo, String direccionImagen, String nombre) {
		return equipoRepository.actualizarEquipo(idEquipo, direccionImagen, nombre);
	}

	@Override
	@Transactional
	public int guardarEquipo(String nombre, String direccionImagen) {
		return equipoRepository.guardarEquipo(nombre, direccionImagen);
	}

}