package com.qatar.proyecto.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.qatar.proyecto.entities.Jugador;
import com.qatar.proyecto.repositories.IJugadorRepository;
import com.qatar.proyecto.services.IJugadorService;


@Service("jugadorService")
public class JugadorService implements IJugadorService{
	
	@Autowired
	@Qualifier("jugadorRepository")
	private IJugadorRepository jugadorRepository;

	@Override
	public List<Jugador> getAll() {
		return jugadorRepository.findAll();
	}

	@Override
	public Jugador buscar(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Jugador jugador) {
		jugadorRepository.save(jugador);
		
	}
}