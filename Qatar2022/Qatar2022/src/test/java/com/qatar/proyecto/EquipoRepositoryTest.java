package com.qatar.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.repositories.IEquipoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EquipoRepositoryTest {
	
	@Autowired
	private IEquipoRepository equipoRepository;
	
	Equipo equipo;
	
	@BeforeEach
	void beforeAll() {
		//Creo un equipo para actualizar y eliminar
		System.out.println("\nInicio de EquipoRepositoryTest\n");
	}
	
	@AfterEach
	void finishMethodTest() {
		System.out.println("\nTermino el metodo de prueba\n");
	}

	@Test
	@DisplayName("creo dos equipos uno con direccion de imagen y otro sin y los guardo en la base de datos de prueba")
	void guardarEquipoTest() {
		
		//Creo equipo con direccionImagen
		Equipo equipo1 = new Equipo();
		equipo1.setNombre("Senegal");
		equipo1.setDireccionImagen("");
		assertEquals(1,equipoRepository.guardarEquipo(equipo1.getNombre(),equipo1.getDireccionImagen()), 
				"No se pudo guardar el equipo: " + equipo1.getNombre() + "en la base de datos");
		
		//Creo equipo sin direccionImagen
		Equipo equipo2 = new Equipo();
		equipo2.setNombre("San Marino");
		assertEquals(1, equipoRepository.guardarEquipo(equipo2.getNombre(), null),
				"No se pudo guardar el equipo: " + equipo2.getNombre() + "en la base de datos");
		
		Equipo equipo3 = new Equipo();
		equipo3.setNombre("Noruega");
		assertEquals(1, equipoRepository.guardarEquipo(equipo3.getNombre(), null),
				"No se pudo guardar el equipo: " + equipo3.getNombre() + "en la base de datos");
	}
	
	@Test
	@DisplayName("busca en la base de datos un equipo con nombre Senegal y si lo encuentra pasa el test")
	void buscarPorNombre() {
		
		String nombreEquipo = "Senegal";
		Equipo equipo = equipoRepository.findByNombre(nombreEquipo);
		
		assertTrue(nombreEquipo.equals(equipo.getNombre()), "No se encontro en la base de datos a: " + equipo.getNombre());
	}
	
	@Test
	@DisplayName("busca en la base de datos de prueba el equipo con nombre Chile y no lo encuentra porque no existe")
	void buscarPorNombreNoExistente() {
		
		String nombreEquipo = "Chile";
		Equipo equipo = equipoRepository.findByNombre(nombreEquipo);
		
		assertNull(equipo, "Se encontro en la base de datos a: " + nombreEquipo); 
	}
	
	@Test
	@DisplayName("actualiza Senegal")
	void actualizarEquipo() {
		
		//Caso en el que un equipo no tiene direccionImagen y al editar le agregamos una
		
		Equipo senegal = new Equipo();// Senegal le agrego una direccionImagen
		senegal.setIdEquipo((long)1);
		senegal.setNombre("Senegal");
		senegal.setDireccionImagen("https://upload.wikimedia.org/wikipedia/commons/f/fd/Flag_of_Gales.svg");
		
		assertNotNull(equipoRepository.buscarPorId(senegal.getIdEquipo()), "No encontro ningun equipo con id: " + senegal.getIdEquipo());
		
		equipoRepository.actualizarEquipo(senegal.getIdEquipo(), senegal.getDireccionImagen(), senegal.getNombre());
		
		Equipo senegalActualizado = equipoRepository.buscarPorId(senegal.getIdEquipo());
		
		assertNotNull(senegalActualizado.getDireccionImagen(), "No se pudo actualizar el equipo con nombre: " + senegal.getNombre());
	}
	
	@Test
	@Rollback(false)
	@DisplayName("elimina a Noruega de la base de datos")
	void eliminarEquipo() {
		
		Equipo noruega = new Equipo();
		noruega.setNombre("Noruega");
		
		Equipo existeNoruega = equipoRepository.findByNombre(noruega.getNombre());
		assertNotNull(existeNoruega, "No existe Noruega en la base de datos");
		
		equipoRepository.eliminarEquipo(existeNoruega.getIdEquipo());
		
		Equipo noExisteNoruega = equipoRepository.findByNombre(noruega.getNombre());
		assertNull(noExisteNoruega, "Todavia existe Noruega");
	}
}
