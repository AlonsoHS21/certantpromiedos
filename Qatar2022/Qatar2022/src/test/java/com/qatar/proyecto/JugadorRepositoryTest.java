package com.qatar.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.entities.Jugador;
import com.qatar.proyecto.repositories.IEquipoRepository;
import com.qatar.proyecto.repositories.IJugadorRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JugadorRepositoryTest {
	
	@Autowired
	private IJugadorRepository jugadorRepository;
	
	@Autowired
	private IEquipoRepository equipoRepository;
	
	@Test
	@DisplayName("guarda el jugador Mane y Koulibaly en la tabla jugadores y los asocia al equipo de Senegal")
	void guardarJugadorTest() {
		
		Equipo senegal = equipoRepository.findByNombre("Senegal");
		assertNotNull(senegal);
		
		Jugador jugador1 = new Jugador("Sadio"," Mane", senegal, 0, 10);
		jugadorRepository.save(jugador1);
		
		Jugador jugador2 = new Jugador("Kalidou", "Koulibaly", senegal, 0, 4);
		jugadorRepository.save(jugador2);
		
		assertAll(
				()-> {
					assertNotNull(jugadorRepository.buscarJugadorPorId((long)1), "No se encontro al jugador:" + jugador1.getNombre());
					},
				() -> {
					assertNotNull(jugadorRepository.buscarJugadorPorId((long)2), "No se encontro al jugador: " + jugador2.getNombre());
				});
	}
	
	@Test
	@DisplayName("Modifica los goles del jugador Mane")
	void modificarJugadorTest() {
		
		//Busco al jugador para modficar
		Jugador jugador = jugadorRepository.buscarJugadorPorId((long)1);
		assertNotNull(jugador, "No existe el jugador con nombre: " + jugador.getNombre());
		
		//Busco su equipo
		Equipo equipo = equipoRepository.buscarPorId(jugador.getEquipo().getIdEquipo());
		assertNotNull(equipo, "No existe el equipo de nombre: " + equipo.getNombre());
		
		//Actualizo el dorsal del jugador
		int actualizoJugador = jugadorRepository.actualizarJugador(jugador.getApellido(), jugador.getNombre(), jugador.getGoles(), 9, equipo.getIdEquipo(), jugador.getIdJugador());
		
		assertEquals(1, actualizoJugador);
	}
	
	@Test
	@DisplayName("Elimina al jugador Koulibaly")
	void eliminarJugadorTest() {
		Jugador jugador = new Jugador();
		jugador.setIdJugador(2);
		
		int jugadorEliminado = jugadorRepository.eliminarJugador(jugador.getIdJugador());
		
		assertEquals(1, jugadorEliminado);

	}

}
