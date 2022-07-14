package com.qatar.proyecto.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Jugador buscar(Long id) {
		return jugadorRepository.buscarJugadorPorId(id);
	}

	@Override
	@Transactional
	public int eliminarJugador(Long id) {
		return jugadorRepository.eliminarJugador(id);
	}

	@Override
	public void save(Jugador jugador) {
		jugadorRepository.save(jugador);
	}

	@Override
	@Transactional
	public int actualizarJugador(String apellido, String nombre, int goles, int dorsal, Long idEquipo, Long idJugador) {
		return jugadorRepository.actualizarJugador(apellido, nombre, goles, dorsal, idEquipo, idJugador);
	}

	@Override
	public List<Jugador> buscarJugadoresPorIdEquipo(Long id) {
		return jugadorRepository.buscarJugadoresPorIdEquipo(id);
	}
}