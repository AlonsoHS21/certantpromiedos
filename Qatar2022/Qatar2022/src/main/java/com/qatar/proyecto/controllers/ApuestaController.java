package com.qatar.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qatar.proyecto.entities.Apuesta;
import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.entities.Usuario;
import com.qatar.proyecto.services.IApuestaService;
import com.qatar.proyecto.services.IEquipoService;
import com.qatar.proyecto.services.IUsuarioService;

@Controller
@RequestMapping("/apuesta")
public class ApuestaController {

	@Autowired
	@Qualifier("apuestaService")
	private IApuestaService apuestaService;
	
	@Autowired
	@Qualifier("usuarioService") 
	private IUsuarioService usuarioService;
	
	@Autowired
	@Qualifier("equipoService") 
	private IEquipoService equipoService;
	
	
	/* ----------------- LISTAR APUESTAS ----------------- */
	
	@GetMapping("/")
	public String lista(
			Model model
			) {
		Usuario usuario = new Usuario();
		List<Apuesta> listaDeApuestas = apuestaService.getAll();
		List<Equipo> listaEquipos = equipoService.getAll();
		List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
		model.addAttribute("apuestas", listaDeApuestas);
		model.addAttribute("equipos", listaEquipos);
		model.addAttribute("usuarios", listaUsuarios);
		model.addAttribute("usuario", usuario);
		return "apuesta/lista";
	}
	
	@GetMapping("/busqueda")
	public String busquedaApuestaPorUsuario(
			Model model,
			@RequestParam(value = "query", required = false) String email
			) {
		Usuario usuario = usuarioService.buscarUsuarioPorEmail(email);
		List<Apuesta> listaApuestas = apuestaService.buscarApuestasPorIdUsuario(usuario.getId());
		model.addAttribute("apuestas",listaApuestas);
		List<Equipo> listaEquipos = equipoService.getAll();
		List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
		model.addAttribute("equipos", listaEquipos);
		model.addAttribute("usuarios", listaUsuarios);
		return "apuesta/lista";
	}

}
