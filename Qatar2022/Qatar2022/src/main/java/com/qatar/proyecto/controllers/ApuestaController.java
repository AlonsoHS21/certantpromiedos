package com.qatar.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		List<Apuesta> listaDeApuestas = apuestaService.getAll();
		List<Equipo> listaEquipos = equipoService.getAll();
		List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
		model.addAttribute("apuestas", listaDeApuestas);
		model.addAttribute("equipos", listaEquipos);
		model.addAttribute("usuarios", listaUsuarios);
		return "apuesta/lista";
	}
	
	@GetMapping("/busqueda")
	public String busquedaApuestaPorUsuario(
			Model model,
			@RequestParam(value = "query", required = false) String email,
			RedirectAttributes redirect
			) {
		Usuario usuario = usuarioService.buscarUsuarioPorEmail(email);
		if(usuario != null) {
			List<Apuesta> listaApuestas = apuestaService.buscarApuestasPorIdUsuario(usuario.getId());
			if(!listaApuestas.isEmpty()) {
				model.addAttribute("apuestas",listaApuestas);
				List<Equipo> listaEquipos = equipoService.getAll();
				List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
				model.addAttribute("equipos", listaEquipos);
				model.addAttribute("usuarios", listaUsuarios);
				return "apuesta/lista";
			}
			redirect.addFlashAttribute("info", "INFO: El usuario no tiene apuestas");
			return "redirect:/apuesta/";
		}
		redirect.addFlashAttribute("info", "INFO: El usuario no fue encontrado");
		return "redirect:/apuesta/";
		
	}

}
