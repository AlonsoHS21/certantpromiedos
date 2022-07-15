package com.qatar.proyecto.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public Partido findById(Long idPartido) {
		return partidoRepository.buscarPartidoPorId(idPartido);
	}

	@Override
	@Transactional
	public int actualizarPartido(String estadio, String estadoApuesta, String fasePartido,String fechaPartido, Long equipoLocal,
			Long equipoVisitante, int resultadoEquipoLocal, int resultadoEquipoVisitante, Long idPartido) {
		return partidoRepository.actualizarPartido(estadio, estadoApuesta, fasePartido,fechaPartido, equipoLocal, equipoVisitante,resultadoEquipoLocal, resultadoEquipoVisitante, idPartido);
	}

	@Override
	@Transactional
	public int cargarResultadoPartido(int resultadoEquipoLocal, int resultadoEquipoVisitante, Long idPartido) {
		return partidoRepository.cargarResultadoPartido(resultadoEquipoLocal, resultadoEquipoVisitante, idPartido);
	}

}
