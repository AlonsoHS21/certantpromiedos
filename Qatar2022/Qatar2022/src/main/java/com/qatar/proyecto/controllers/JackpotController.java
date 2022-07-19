package com.qatar.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.entities.Jackpot;
import com.qatar.proyecto.entities.Jugador;
import com.qatar.proyecto.entities.Usuario;
import com.qatar.proyecto.services.IEquipoService;
import com.qatar.proyecto.services.IJackpotService;
import com.qatar.proyecto.services.IJugadorService;
import com.qatar.proyecto.services.IUsuarioService;

@Controller
@RequestMapping("/jackpot")
public class JackpotController {
	
	@Autowired
	@Qualifier("jackpotService")
	private IJackpotService jackpotService;
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@Autowired
	@Qualifier("jugadorService")
	private IJugadorService jugadorService;
	
	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;
	
	@GetMapping("/")
	public String lista(
			RedirectAttributes redirect,
			Model model
			) {
		List<Jackpot> listaJackpots = jackpotService.getAll();
		if(!listaJackpots.isEmpty()) {
			List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
			List<Equipo> listaEquipos = equipoService.getAll();
			List<Jugador> listaJugadores = jugadorService.getAll();
			model.addAttribute("usuarios", listaUsuarios);
			model.addAttribute("jackpots", listaJackpots);
			model.addAttribute("equipos", listaEquipos);
			model.addAttribute("jugadores", listaJugadores);
			return "jackpot/lista";
		}
		redirect.addFlashAttribute("info","INFO: No se encontraron jackpots para ningun usuario");
		return "redirect:/jackpot/";
	}

}
