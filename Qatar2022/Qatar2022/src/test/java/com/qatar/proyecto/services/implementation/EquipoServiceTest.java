package com.qatar.proyecto.services.implementation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.repositories.IEquipoRepository;
import com.qatar.proyecto.services.implementation.EquipoService;

class EquipoServiceTest {
	
	@Mock //Con esta etiqueta le decimos 
	// que es un objeto simulado o mock osea que realmente no esta llamando al repositorio de equipo
	private IEquipoRepository equipoRepository;
	
	@InjectMocks 
	// Con esto indicamos que la clase recibira como dependencia el mock indicado arriba
	private EquipoService equipoService;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);	
	}
	@DisplayName("Dado el equipo creado con anterioridad en setUp() este metodo" + 
	" se encarga de buscar por su nombre y como resultado espera un objeto de tipo Equipo")
	@Test
	void buscarPorNombreEquipoTest() {
		/*
		when(equipoRepository.findByNombre(any(String.class))).thenReturn(equipo);
		
		Equipo equipo = equipoService.buscar("Mexico");
		
		assertAll(
				() -> {assertEquals(1,equipo.getIdEquipo());},
				() -> {assertEquals("Mexico", equipo.getNombre());},
				() -> {assertNotNull(equipo);}
				);*/
		Equipo simulado = new Equipo(1L, "Mexico"); // Simula lo que traeriamos de la base de datos
		Equipo esperado = new Equipo(1L, "Mexico"); // Este seria el resultado esperado 
		
		Mockito.when(equipoRepository.findByNombre("Mexico"))
			.thenReturn(simulado); //Me trae el resultado simulado
		
		final Equipo resultado = equipoService.findByNombre("Mexico");
		
		assertEquals(esperado.getIdEquipo(), resultado.getIdEquipo());
		assertEquals(esperado.getNombre(), resultado.getNombre());
		assertEquals(resultado, simulado);
		
		Mockito.verify(equipoRepository).findByNombre("Mexico");
		//Con esto le decimos a Mockito cuantas veces queremos llamar al metodo findByNombre por defecto es 1
	}
	
	@Test
	@Disabled
	void buscarPorIdEquipoTest() {
		/*
		when(equipoRepository.findById(any(Long.class))).thenReturn(Optional.of(equipo));
		
		Equipo equipo = equipoService.buscarPorId(1L);
		
		assertAll(
				() -> {assertNotNull(equipo, "En buscarPorIdEquipo el equipo buscado es nulo");},
				() -> {assertEquals(1, equipo.getIdEquipo(), "En buscarPorIdEquipo no se econtro el id");}
				);*/
		Equipo simulado = new Equipo(1L, "Mexico");
		Equipo esperado = new Equipo(1L, "Mexico");
		
		Mockito.when(equipoRepository.findById(1L))
			.thenReturn(Optional.of(simulado));
		
		final Equipo resultado = equipoService.buscarPorId(1L);
		
		assertEquals(esperado.getIdEquipo(), resultado.getIdEquipo());
		assertEquals(esperado.getNombre(), resultado.getNombre());
		assertEquals(resultado, simulado);
		
		Mockito.verify(equipoRepository).findById(1L);
		
	}
	
	@Test
	void guardarEquipoTest() {
		
		int esperado = 1;
		
		Mockito.when(equipoRepository.guardarEquipo("Mexico", ""))
			.thenReturn(esperado);
		
		final int resultado = equipoService.guardarEquipo("Mexico", "");
		
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	void eliminarEquipoTest() {
		when(equipoRepository.eliminarEquipo(any(Long.class))).thenReturn(1);
		
		int eliminaEquipo = equipoService.eliminar(1L);
		
		assertEquals(1, eliminaEquipo);
	
	}
	
	@Test
	void actualizarEquipoTest() {
		when(equipoRepository.actualizarEquipo(any(Long.class), any(String.class), any(String.class))).thenReturn(1);
		
		int actualizaEquipo = equipoService.actualizarEquipo(1L, "bandera-tailandia.png", "Tailandia");
		
		assertEquals(1, actualizaEquipo);
	}

}
