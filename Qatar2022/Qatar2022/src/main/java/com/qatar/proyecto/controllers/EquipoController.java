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
import com.qatar.proyecto.entities.Jugador;
import com.qatar.proyecto.services.IJugadorService;
import com.qatar.proyecto.services.implementation.EquipoService;


@Controller
@RequestMapping("/equipo")
public class EquipoController {
	
	@Autowired
	@Qualifier("equipoService") 
	private EquipoService equipoService;
	
	@Autowired
	@Qualifier("jugadorService")
	private IJugadorService jugadorService;
	
	/* ----------------- LISTAR EQUIPO ----------------- */ 
	
	@GetMapping("/")
	public String lista(
			Model model
			) {
		List<Equipo> listaEquipo = equipoService.getAll();
		List<Jugador> listaJugadores = jugadorService.getAll();
		model.addAttribute("equipos",listaEquipo);
		model.addAttribute("jugadores", listaJugadores);
		return "equipo/lista";
	}
	
	/* ----------------- LISTAR JUGADORES X EQUIPO ----------------- */ 
	
	@GetMapping("/listarJugadores/{idEquipo}")
	public String listaJugadorePorEquipo(
			@PathVariable Long idEquipo,
			Model model
			) {
		List<Jugador> listaJugadores = jugadorService.buscarJugadoresPorIdEquipo(idEquipo);
		model.addAttribute("listaJugadoresPorEquipo", listaJugadores);
		return "jugador/lista";
	}
	
	/* ----------------- GUARDAR EQUIPO ----------------- */ 
	
	@GetMapping("/agregar")
	public String agregar(
			Equipo equipo, 
			Model model
			) {
		return "equipo/crear";
	}
	
	
	@PostMapping("/guardar")
	public String guardar(
			@Valid Equipo equipo,
			BindingResult result,
			Model model,
			RedirectAttributes redirect
			) {
		boolean errores = result.hasErrors();
		if(errores) {
			model.addAttribute("equipo", equipo);
			System.out.println("Hubo errores en el formulario de guardar equipo");
			return "equipo/crear";
		}
		equipoService.guardarEquipo(equipo.getNombre(), equipo.getDireccionImagen());
		System.out.println("Equipo guardado con exito!");
		redirect.addFlashAttribute("save", "Equipo guardado con exito!");
		return "redirect:/equipo/agregar";
	}
	
	/* ----------------- EDITAR EQUIPO ----------------- */ 
	
	@GetMapping("/editar/{idEquipo}")
	public String redirigirEditar(
			@PathVariable Long idEquipo,
			Model model
			) {
		model.addAttribute("equipo", equipoService.buscarPorId(idEquipo));
		return "equipo/editar";
	}
	
	@PostMapping("/editar/{idEquipo}")
	public String editar(
			@PathVariable Long idEquipo,
			RedirectAttributes redirect,
			@ModelAttribute("equipo") Equipo equipo,
			Model model
			) {
		Equipo equipoEncontrado = equipoService.buscarPorId(idEquipo);
		System.out.println("Entro al post de editar");
		if(equipoEncontrado != null) {
			equipoService.actualizarEquipo(idEquipo, equipo.getDireccionImagen(), equipo.getNombre());
			System.out.println("Equipo editado con exito!");
			redirect.addFlashAttribute("edit", "Equipo editado con exito!");
			return "redirect:/equipo/editar/{idEquipo}";
		}
		return "equipo/editar/{idEquipo}";
	}
	
	/* ----------------- ELIMINAR EQUIPO ----------------- */ 
	
	@GetMapping("/eliminar/{idEquipo}")
	public String eliminar(
			@PathVariable Long idEquipo,
			RedirectAttributes redirect
			) {
		equipoService.eliminar(idEquipo);
		System.out.println("Equipo eliminado con exito!");
		redirect.addFlashAttribute("delete", "Equipo eliminado con exito!");
		return "redirect:/equipo/";
	}
	
	/*
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Equipo equipo, BindingResult result, Model model, RedirectAttributes attribute) {
		if(equipoService.findByNombre(equipo.getNombre())!= null) {
			FieldError error = new FieldError("equipo", "nombre", "Ya existe un equipo con este nombre");
			result.addError(error);
		}
		
		if(result.hasErrors()) {
			System.out.println("Hubo error en el formulario!");
			return "equipo/crear";
		}
		equipoService.save(equipo);
		System.out.println("Equipo guardado con exito!");
		attribute.addFlashAttribute("success","Equipo creado con exito");
		return "redirect:/equipo/";
	}
	*/
}
	/* ------------------------------------ SWAGGR ------------------------------------ */
	/* 
	 @RestController
	@RequestMapping("/api/equipo")
	public class EquipoController {
	
	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;
	
	//GET
	@GetMapping
	public List<Equipo> listaEquipos(){
		return equipoService.getAll();
	}
	
	//GET BY ID
	@GetMapping("/{id}")
	public Equipo buscarEquipo(@PathVariable Long id) {
		return equipoService.buscarPorId(id);
	}
	
	//POST
	@PostMapping
	public void agregarEquipo(@RequestBody Equipo equipo){
		equipoService.save(equipo);
	}
	
	//PUT
	@PutMapping("/{id}")
	public ResponseEntity<Equipo> actualizarEquipo(
			@PathVariable(value = "id") Long id,
			@RequestBody Equipo equipo)
	{
		Equipo equipoEncontrado = equipoService.buscarPorId(id); //Busco para ver si existe el equipo porque quizas el id recibido no exista
		
		if(equipoEncontrado != null) {
			
			int rows = equipoService.actualizarEquipo(id,equipo.getDireccionImagen(),equipo.getNombre());
			
			if(rows > 0 ) {
				return new ResponseEntity<Equipo>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Equipo>(HttpStatus.INTERNAL_SERVER_ERROR); 			}
		}
		return new ResponseEntity<Equipo>(HttpStatus.BAD_REQUEST); 
	}
	
	@DeleteMapping("/{id}") //TODO:No esta terminado el delete de equipocontroller
	public ResponseEntity<Equipo> eliminarEquipo(
			@PathVariable(value = "id") Long id
			){
		int rows = equipoService.eliminar(id);
		
		if(rows > 0) {
			return new ResponseEntity<Equipo>(HttpStatus.CREATED); //Se modifico correctamente
		}else {
			return new ResponseEntity<Equipo>(HttpStatus.INTERNAL_SERVER_ERROR); //Hubo un error y la solicitud no pude ser completada
		}
	}
	 */
	
