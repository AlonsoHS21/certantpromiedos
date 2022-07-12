package com.qatar.proyecto.controllers;

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
		return "partido/lista";
	}
	
	/* ----------------- INGRESAR PARTIDOS ----------------- */ 
	
	@GetMapping("/agregar")
	public String crear(
			Model model
			) {
		System.out.println("Entro a /agregar");
		Partido partido = new Partido();
		List<Equipo> listaEquipos = equipoService.getAll();
		model.addAttribute("partido", partido);
		model.addAttribute("Equipos", listaEquipos);
		return "partido/crear"; //Voy al crear.html de partido
	}
	
	@PostMapping("/guardar")
	public String guardar(
			Partido partido
			) {
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
