package com.qatar.proyecto.services.implementation;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.qatar.proyecto.entities.Apuesta;
import com.qatar.proyecto.repositories.IApuestaRepository;

@RunWith(MockitoJUnitRunner.class)
class ApuestaServiceTest {
	
	@Mock
	IApuestaRepository apuestaRepository;
	
	@InjectMocks
	private ApuestaService apuestaService;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("")
	void buscarPorPalabraClaveApuestaTest() {
		
		List<Apuesta> listaApuestas = new ArrayList<Apuesta>();
		listaApuestas.add(DatosApuesta.APUESTA1);
		
		Mockito.when(apuestaRepository.buscarApuestasPorPalabra("Huarcaya"))
			.thenReturn(listaApuestas);
		Mockito.when(apuestaRepository.buscarApuestasPorPalabra("Alonso"))
			.thenReturn(listaApuestas);
		Mockito.when(apuestaRepository.buscarApuestasPorPalabra("Huar"))
			.thenReturn(listaApuestas);
		
		List<Apuesta> listaApuestasPorUsuarios1 = apuestaService.buscarApuestasPorPalabra("Huarcaya");
		List<Apuesta> listaApuestasPorUsuarios2 = apuestaService.buscarApuestasPorPalabra("Alonso");
		List<Apuesta> listaApuestasPorUsuarios3 = apuestaService.buscarApuestasPorPalabra("Huar");
		
		Assertions.assertEquals(listaApuestas, listaApuestasPorUsuarios1);
		Assertions.assertEquals(listaApuestas, listaApuestasPorUsuarios2);
		Assertions.assertEquals(listaApuestas, listaApuestasPorUsuarios3);
	}
	
	@Test
	@DisplayName("")
	void buscarApuestaPorIdUsuarioTest() {
		
		List<Apuesta> listaApuestas1 = new ArrayList<Apuesta>();
		listaApuestas1.add(DatosApuesta.APUESTA1);
		
		List<Apuesta> listaApuestas2 = new ArrayList<Apuesta>();
		listaApuestas2.add(DatosApuesta.APUESTA2);
		
		List<Apuesta> listaApuestas3 = new ArrayList<Apuesta>();
		listaApuestas3.add(DatosApuesta.APUESTA3);
		
		Mockito.when(apuestaRepository.buscarApuestasPorIdUsuario(1L))
			.thenReturn(listaApuestas1);
		
		Mockito.when(apuestaRepository.buscarApuestasPorIdUsuario(2L))
			.thenReturn(listaApuestas2);
		
		Mockito.when(apuestaRepository.buscarApuestasPorIdUsuario(3L))
			.thenReturn(listaApuestas3);
		
		
		List<Apuesta> listaApuestasPorUsuario1 = apuestaService.buscarApuestasPorIdUsuario(1L);
		List<Apuesta> listaApuestasPorUsuario2 = apuestaService.buscarApuestasPorIdUsuario(2L);
		List<Apuesta> listaApuestasPorUsuario3 = apuestaService.buscarApuestasPorIdUsuario(3L);
		
		Assertions.assertAll(
				() -> Assertions.assertEquals(listaApuestas1, listaApuestasPorUsuario1),
				() -> Assertions.assertEquals(listaApuestas2, listaApuestasPorUsuario2),
				() -> Assertions.assertEquals(listaApuestas3, listaApuestasPorUsuario3)
				);
		
		
	}

}
