package com.qatar.proyecto.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.qatar.proyecto.entities.Partido;
import com.qatar.proyecto.repositories.IPartidoRepository;
import com.qatar.proyecto.services.IPartidoService;

@Service("partidoService")
public class PartidoService implements IPartidoService {
	
	@Autowired
	@Qualifier("partidoRepository")
	private IPartidoRepository partidoRepository;
		
	@Override
	public List<Partido> getAll() {
		return partidoRepository.findAll();
	}

	@Override
	public void save(Partido partido) {
		partidoRepository.save(partido);
	}

	@Override
	public void eliminar(Long idPartido) {
		partidoRepository.deleteById(idPartido);
	}
}
