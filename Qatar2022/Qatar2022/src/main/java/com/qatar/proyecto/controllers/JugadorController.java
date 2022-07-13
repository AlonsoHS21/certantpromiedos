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
	
	/* ----------------- LISTAR JUGADOR ----------------- */ 
	
 	@GetMapping("/")
	public String lista(Jugador jugador, Model model) {
		List<Jugador> listaJugadores = jugadorService.getAll();
		model.addAttribute("jugadores", listaJugadores);
		return "jugador/lista";
	}
 	
 	/* ----------------- GUARDAR JUGADOR ----------------- */ 
 	
 	@GetMapping("/agregar")
 	public String crear(
 			Model model
 			) {
 		Jugador jugador = new Jugador();
 		List<Equipo> listaEquipos = equipoService.getAll();
		model.addAttribute("jugador", jugador);
		model.addAttribute("equipos", listaEquipos);
		return "jugador/crear";
 	}
 	
 	@PostMapping("/guardar")
	public String guardar(
			@Valid Jugador jugador,
			BindingResult result,
			Model model
			) {
 		if(result.hasErrors()) {
 			model.addAttribute("equipos", equipoService.getAll());
 			model.addAttribute("mensaje", "Mensaje de error");
 			return "redirect:/jugador/agregar";
 		}
		jugadorService.save(jugador);
		return "redirect:/jugador/";
 	}
 	
 	/* ----------------- EDITAR JUGADOR ----------------- */ 
 	
 	@GetMapping("/editar/{idJugador}")
	public String redirigirEditar(
			@PathVariable Long idJugador,
			Model model
			) {
 		List<Equipo> listaEquipos = equipoService.getAll();
		model.addAttribute("jugador", jugadorService.buscar(idJugador));
		model.addAttribute("equipos", listaEquipos);
		return "jugador/editar";
	}
	
	@PostMapping("/editar/{idJugador}")
	public String editar(
			@PathVariable Long idJugador,
			@ModelAttribute("jugador") Jugador jugador,
			Model model
			) {
		Jugador jugadorEncontrado = jugadorService.buscar(idJugador);
		if(jugadorEncontrado != null) {
			jugadorService.actualizarJugador(jugador.getApellido(), jugador.getNombre(), jugador.getGoles(), jugador.getDorsal(), jugador.getEquipo().getIdEquipo(), idJugador);
			return "redirect:/jugador/";
		}
		return "equipo/editar/{idJugador}";
	}
 	
 	/* ----------------- ELIMINAR JUGADOR ----------------- */ 
 	
 	@GetMapping("eliminar/{idJugador}")
 	public String eliminar(
 			@PathVariable Long idJugador
 			) {
 		jugadorService.eliminarJugador(idJugador);
 		return "redirect:/jugador/";
 	}
 	
}	

	
	/*
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

/* -------------------------- SWAGGR ---------------------- */
/*
//@RestController
//@RequestMapping("/api/jugador")
public class JugadorController {
	
	@Autowired
	@Qualifier("jugadorService")
	private IJugadorService jugadorService;
	
	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;
	
	@GetMapping
	public List<Jugador> listaJugadores(){
		System.out.println("Entro en la lista de jugadores");
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
	
	@PutMapping("/{id}")
	public ResponseEntity<Jugador> actualizarJugador(
			@PathVariable Long id,
			@RequestBody Jugador jugador
			){
		Jugador jugadorEncontrado = jugadorService.buscar(id); //Busco para ver si existe el equipo porque quizas el id recibido no exista
		
		if(jugadorEncontrado != null) {
			
			int rows = jugadorService.actualizarJugador(jugador.getApellido(), jugador.getNombre(),jugador.getGoles(), jugador.getEquipo().getIdEquipo(),id);
			
			if(rows > 0 ) {
				return new ResponseEntity<Jugador>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Jugador>(HttpStatus.INTERNAL_SERVER_ERROR); 			}
		}
		return new ResponseEntity<Jugador>(HttpStatus.BAD_REQUEST); 
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
	
	}*/

