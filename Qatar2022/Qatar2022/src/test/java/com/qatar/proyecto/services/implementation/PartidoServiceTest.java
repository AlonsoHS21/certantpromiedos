package com.qatar.proyecto.services.implementation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.entities.Partido;
import com.qatar.proyecto.repositories.IPartidoRepository;
import com.qatar.proyecto.services.implementation.PartidoService;

class PartidoServiceTest {
	
	@Mock
	private IPartidoRepository partidoRepository; 
	
	@InjectMocks
	private PartidoService partidoService;
	
	@Test
	@Disabled
	void buscarPartidoPorIdTest() {
		Equipo equipo1 = new Equipo(1L, "Argentina");
		Equipo equipo2 = new Equipo(2L, "Brasil");
		
		Partido partidoSimulado = new Partido(1L,"Grupo B", "Qatar", "2022/08/08T23:00", "Abierta", equipo1.getIdEquipo(), equipo2.getIdEquipo());
		Partido partidoEsperado = new Partido(1L,"Grupo B", "Qatar", "2022/08/08T23:00", "Abierta", equipo1.getIdEquipo(), equipo2.getIdEquipo());
		
		Mockito.when(partidoRepository.buscarPartidoPorId(1L))
		.thenReturn(partidoSimulado);
		
		final Partido resultado = partidoService.findById(1L);
		
		assertEquals(resultado.getIdPartido(), partidoEsperado.getIdPartido());
	
	}
	
	@Test
	void actualizarPartidoTest() {
		
	}
	
	@Test
	@Disabled
	void cargarResultadoPartidoTest() {
		
		int resultadoEsperado = 3;
		
		Mockito.when(partidoRepository.cargarResultadoPartido(1, 2, 1L)).thenReturn(2);
		
		final int resultado = partidoService.cargarResultadoPartido(1, 2, 1L);
		
	}

}
