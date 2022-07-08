package com.qatar.proyecto.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.entities.Jugador;
import com.qatar.proyecto.entities.Usuario;
import com.qatar.proyecto.services.IEquipoService;
import com.qatar.proyecto.services.IJugadorService;


//@Controller
//@RequestMapping("/jugador")
@RestController
@RequestMapping("/api/jugador")
public class JugadorController {
	
	@Autowired
	@Qualifier("jugadorService")
	private IJugadorService jugadorService;
	
	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;
	
	@GetMapping
	public List<Jugador> listaJugadores(){
		return jugadorService.getAll();
	}
	
	@GetMapping("/{id}")
	public Jugador buscarJugadorPorId(@PathVariable Long id) {
		return jugadorService.buscar(id);
	}
	
	@PostMapping
	public void agregarJugador(@RequestBody Jugador jugador) {
		jugadorService.save(jugador);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Jugador> eliminarJugador(@PathVariable Long id) {
		
		Jugador jugador = jugadorService.buscar(id);
		
		if(jugador != null) {
			
			int rows = jugadorService.eliminarJugador(id);
			
			if(rows > 0) {
				return new ResponseEntity<Jugador>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Jugador>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}else {
			return new ResponseEntity<Jugador>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	}
/*
 * 
 * @GetMapping("/")
	public String lista(Jugador jugador, Model model) {
		List<Jugador> listaJugadores = jugadorService.getAll();
		model.addAttribute("jugador", listaJugadores);
		return "jugador/lista";
	}

	@RequestMapping("/crear")
	public String crear(Model model) {
		Jugador jugador = new Jugador();
		List<Equipo> listaEquipos = equipoService.getAll();
		model.addAttribute("jugador", jugador);
		model.addAttribute("equipos", listaEquipos);
		return "jugador/crear";
	}
	
	@PostMapping("/guardar")
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
 */

