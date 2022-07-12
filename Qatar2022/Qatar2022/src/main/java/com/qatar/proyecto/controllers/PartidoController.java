package com.qatar.proyecto.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.entities.Partido;
import com.qatar.proyecto.services.IEquipoService;
import com.qatar.proyecto.services.IPartidoService;

@Controller
@RequestMapping("/partido")
public class PartidoController {
	
	@Autowired
	@Qualifier("partidoService")
	private IPartidoService partidoService;
	
	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;
	
	/* ----------------- LISTAR PARTIDOS ----------------- */ 
	
	@GetMapping("/")
	public String lista(Model model) {
		List<Partido> listaPartidos = partidoService.getAll();
		model.addAttribute("partidos",listaPartidos);
		model.addAttribute("local", equipoService.buscarPorId(listaPartidos.get(0).getIdEquipoLocal()));
		model.addAttribute("visitante", equipoService.buscarPorId(listaPartidos.get(0).getIdEquipoVisitante()));
		return "partido/lista";
	}
	
	/* ----------------- INGRESAR PARTIDOS ----------------- */ 
	
	@GetMapping("/agregar")
	public String crear(
			Model model
			) {
		Partido partido = new Partido();
		List<Equipo> listaEquipos = equipoService.getAll();
		model.addAttribute("partido", partido);
		model.addAttribute("listaEquipos", listaEquipos);
		return "partido/crear";
	}
	
	@PostMapping("/guardar")
	public String guardar(
			Partido partido
			) {
	System.out.println(partido.getFechaPartido());
		
	partidoService.save(partido);
	return "redirect:/partido/";
	}
	
	/* ----------------- EDITAR PARTIDOS ----------------- */ 
	
	/* ----------------- ELIMINAR PARTIDOS ----------------- */ 
	
	@GetMapping("/eliminar/{idPartido}")
	public String eliminar(
			@PathVariable Long idPartido
			) {
		partidoService.eliminar(idPartido);
		return "redirect:/partido/";
	}

}
