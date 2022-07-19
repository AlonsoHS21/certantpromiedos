package com.qatar.proyecto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		if(!listaPartidos.isEmpty()) {
			List<Equipo> listaEquipos = equipoService.getAll();
			model.addAttribute("partidos",listaPartidos);
			model.addAttribute("equipos", listaEquipos);
			return "partido/lista";
		}
		model.addAttribute("info", "No se encontraron partidos para listar");
		return "partido/lista";
	}
	
	/* ----------------- LISTAR EQUIPOS X PARTIDO ----------------- */ 
	
	@GetMapping("/listarEquipos/{idPartido}")
	public String listarEquipos(
			@PathVariable Long idPartido,
			Model model){
		Partido partido = partidoService.findById(idPartido);
		model.addAttribute("local", equipoService.buscarPorId(partido.getIdEquipoLocal()));
		model.addAttribute("visitante", equipoService.buscarPorId(partido.getIdEquipoVisitante()));
		return "partido/equipos";
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
			@Valid Partido partido,
			BindingResult result,
			Model model,
			RedirectAttributes redirect
			) {
	if(result.hasErrors()) {
			model.addAttribute("partido", partido);
			model.addAttribute("listaEquipos", equipoService.getAll());
			System.out.println("ERROR: Hubo un error en el formulario de guardar partido!");
			return "partido/crear";
		}
	partidoService.save(partido);
	System.out.println("SAVE: Partido guardado con exito!");
	redirect.addFlashAttribute("save", "SAVE: Partido guardado con exito!");
	return "redirect:/partido/agregar";
	}
	
	/* ----------------- EDITAR PARTIDOS ----------------- */ 
	
	@GetMapping("/editar/{idPartido}")
	public String redirigirEditar(
			@PathVariable Long idPartido,
			Model model
			) {
		Partido partido = partidoService.findById(idPartido);
		List<Equipo> listaEquipos = equipoService.getAll();
		model.addAttribute("listaEquipos", listaEquipos);
		model.addAttribute("partido", partido);
		return "partido/editar";
	}
	
	
	@PostMapping("/editar/{idPartido}")
	public String editar(
			@PathVariable Long idPartido,
			@ModelAttribute("partido") Partido partido,
			Model model
			) {
		Partido partidoEncontrado = partidoService.findById(idPartido);
		if(partidoEncontrado != null) {
			partidoService.actualizarPartido(partido.getEstadio(),partido.getEstadoApuesta(),partido.getFasePartido(),partido.getFechaPartido(),partido.getIdEquipoLocal(),partido.getIdEquipoVisitante(),partido.getResultaEquipoLocal(),partido.getResultadoEquipoVisitante(),idPartido);
			return "redirect:/partido/";
		}
		return "partido/editar/{idPartido}";
	}
	
	/* ----------------- ELIMINAR PARTIDOS ----------------- */ 
	
	@GetMapping("/eliminar/{idPartido}")
	public String eliminar(
			@PathVariable Long idPartido
			) {
		partidoService.eliminar(idPartido);
		return "redirect:/partido/";
	}
	
	/* ----------------- CARGAR RESULTADO PARTIDO ----------------- */ 
	
	@GetMapping("/cargarResultados/{idPartido}")
	public String redirigirCargarResultado(
			@PathVariable Long idPartido,
			Model model
			) {
		Partido partido = partidoService.findById(idPartido);
		List<Equipo> listaEquipos = equipoService.getAll();
		model.addAttribute("equipos", listaEquipos);
		model.addAttribute("partido", partido);
		System.out.println("Entro a redirigir cargar resultado");
		return "partido/cargarResultado";
	}
	
	@PostMapping("/cargarResultados/{idPartido}")
	public String cargar(
			@PathVariable Long idPartido,
			@ModelAttribute("partido") Partido partido,
			Model model
			) {
		Partido partidoEncontrado = partidoService.findById(idPartido);
		if(partidoEncontrado != null) {
			partidoService.cargarResultadoPartido(partido.getResultaEquipoLocal(),partido.getResultadoEquipoVisitante(), idPartido);
			return "redirect:/partido/";
		}
		Partido partidoNuevo = partidoService.findById(idPartido);
		List<Equipo> listaEquipos = equipoService.getAll();
		model.addAttribute("equipos", listaEquipos);
		model.addAttribute("partido", partidoNuevo);
		return "partido/editar/{idPartido}";
	}

}
