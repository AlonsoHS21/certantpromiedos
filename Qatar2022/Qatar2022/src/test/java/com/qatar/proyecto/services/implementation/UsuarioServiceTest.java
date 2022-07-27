package com.qatar.proyecto.services.implementation;

import java.util.List;

import org.assertj.core.util.Arrays;
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

import com.qatar.proyecto.entities.Usuario;
import com.qatar.proyecto.repositories.IUsuarioRepository;

@RunWith(MockitoJUnitRunner.class)
class UsuarioServiceTest {

	@Mock
	private IUsuarioRepository usuarioRepository;
	
	@InjectMocks
	private UsuarioService usuarioService;
	
	private Usuario usuario;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
		
		usuario = new Usuario();
		usuario.setId(1L);
		usuario.setContrasenia("1");
		usuario.setEmail("rhuarcaya@certant.com");
		
	}
	
	@Test
	@DisplayName("Busca un usuario por email y si lo encuentra devuelve un objeto de tipo usuario "
			+ "con sus datos o nulo en caso contrario")
	void buscarUsuarioPorEmailTest() {
		
		Mockito.when(usuarioRepository.buscarEmailContrasenia("rhuarcaya@certant.com", "1"))
			.thenReturn(usuario);
		
		Usuario usuario = usuarioRepository.buscarEmailContrasenia("rhuarcaya@certant.com", "1");
		
		Assertions.assertEquals("rhuarcaya@certant.com", usuario.getEmail());
		Assertions.assertEquals("1", usuario.getContrasenia());
		
	}
	
	

}
