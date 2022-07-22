package com.qatar.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.qatar.proyecto.entities.Partido;
import com.qatar.proyecto.repositories.IEquipoRepository;
import com.qatar.proyecto.repositories.IPartidoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class PartidoRepositoryTest {
	
	Partido partido;
	
	@BeforeEach
	void initMethodTest() {
		System.out.println("\nInicio de PartidoRepositoryTest\n");
	}
	
	@AfterEach
	void finishMethodTest() {
		System.out.println("\nTermino Partido RepositoryTest\n");
	}
	
	@Autowired
	private IPartidoRepository partidoRepository;
	
	@Autowired
	private IEquipoRepository equipoRepository;
	
	@Test
	@DisplayName("crea un partido a partir de dos equipos que ya existen en la base de datos de prueba")
	void guardarPartidoTest() {
		
		partido = new Partido();
		partido.setFasePartido("Semifinal");
		partido.setEstadio("Qatar");
		partido.setFechaPartido("2022/11/30T23:00");
		partido.setEstadoApuesta("Abierta");
		
		partido.setIdEquipoLocal((long)1);
		
		assertNotNull(equipoRepository.buscarPorId(partido.getIdEquipoLocal()), "El equipo con id " + partido.getIdEquipoLocal() +" no existe"); //Verifico que exista el equipo
		
		partido.setIdEquipoVisitante((long)2);
		
		assertNotNull(equipoRepository.buscarPorId(partido.getIdEquipoVisitante()), "El equipo con id " + partido.getIdEquipoVisitante() + " no existe"); //Verifico que exista el equipo
		
		partidoRepository.save(partido);
		
		Partido partidoEncontrado = partidoRepository.buscarPartidoPorId((long)1);
		
		assertNotNull(partidoEncontrado, "No se pudo crear un partido");
	}
	
	@Test
	void actualizarPartido() {
		
	}
	
	@Test
	@DisplayName("elimina un partido lo que hace es buscar y si lo encuentra por el id lo elimina en caso contrario avisa de un error")
	void eliminarPartidoTest() {
		
		partido = new Partido();
		partido.setIdPartido((long)1);
		
		Partido partidoEncontrado = partidoRepository.buscarPartidoPorId(partido.getIdPartido());
		
		assertNotNull(partidoEncontrado, "El partido con id " + partido.getIdPartido()
		+ " no fue encontrado");
		
		partidoRepository.deleteById(partidoEncontrado.getIdPartido());
		
		Partido partidoEliminado = partidoRepository.buscarPartidoPorId(partido.getIdPartido());
		
		assertNull(partidoEliminado, "El partido no pude ser eliminado");
	}
}
