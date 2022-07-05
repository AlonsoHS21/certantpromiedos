package com.qatar.proyecto.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.entities.Jugador;
import com.qatar.proyecto.services.IEquipoService;
import com.qatar.proyecto.services.IJugadorService;


@Controller
@RequestMapping("/jugador")
public class JugadorController {
	
	@Autowired
	@Qualifier("jugadorService")
	private IJugadorService jugadorService;
	
	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;
	
	@RequestMapping("/")
	public String crear(Model model) {
		Jugador jugador = new Jugador();
		List<Equipo> listaEquipos = equipoService.getAll();
		model.addAttribute("jugador", jugador);
		model.addAttribute("equipos", listaEquipos);
		return "jugador/crear";
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Jugador jugador, BindingResult result, Model model, RedirectAttributes attribute) {
		
		
		if(result.hasErrors()) {
			List<Equipo> listaEquipos = equipoService.getAll();
			model.addAttribute("equipos", listaEquipos);
			System.out.println("Hubo error en el formulario!");
			return "jugador/crear";
		}
		jugadorService.save(jugador);
		System.out.println("Jugador creado con exito!");
		
		attribute.addFlashAttribute("success","Jugador creado con exito");
		return "redirect:/jugador/";
	}

}
