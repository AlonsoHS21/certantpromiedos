package com.qatar.proyecto.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qatar.proyecto.entities.Apuesta;
import com.qatar.proyecto.repositories.IApuestaRepository;
import com.qatar.proyecto.services.IApuestaService;

@Service("apuestaService")
public class ApuestaService implements IApuestaService {
	
	@Autowired
	@Qualifier("apuestaRepository")
	private IApuestaRepository apuestaRepository;
	
	@Override
	public List<Apuesta> getAll() {
		return apuestaRepository.findAll();
	}

	@Override
	public List<Apuesta> buscarApuestasPorIdUsuario(Long id) {
		return apuestaRepository.buscarApuestasPorIdUsuario(id);
	}

	@Override
	public void save(Apuesta apuesta) {
		apuestaRepository.save(apuesta);
	}

	@Override
	@Transactional
	public int eliminarApuestasPorUsuario(Long id) {
		return apuestaRepository.eliminarApuestasPorUsuario(id);
	}

}
