package com.qatar.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.entities.Usuario;
import com.qatar.proyecto.services.IEquipoService;
import com.qatar.proyecto.services.implementation.EquipoService;
import com.qatar.proyecto.services.implementation.UsuarioService;


@Controller
@RequestMapping("/equipo")
public class EquipoController {
	
	@Autowired
	@Qualifier("equipoService") 
	private EquipoService equipoService;
	
	@GetMapping("/")
	public String lista(Model model) {
		List<Equipo> listaEquipo = equipoService.getAll();
		model.addAttribute("equipos",listaEquipo);
		return "equipo/lista";
	}
	/*
	@GetMapping("/crear")
	public String crear(Equipo equipo) {
		return "equipo/crear"; //Me envia a crear.html
	}
	
	@PostMapping("/guardar")
	public String guardar(Equipo equipo) {
		equipoService.save(equipo);
		return "redirect:/equipo/"; //Me envia a la lista de equipos
	}
	
	@GetMapping("/editar/{idEquipo}")
	public String editar(Equipo equipo, Model model) { //Inicializa con los datos del idEquipo
		equipo = equipoService.findByNombre(equipo.getNombre());
		model.addAttribute("equipo",equipo);
		return "equipo/crear"; //crear.html sirve para modificar y crear
	}
	
	@GetMapping("/eliminar/{idEquipo}")
	public String eliminar(@PathVariable Long id) {
		equipoService.eliminar(id);
		return "redirect:/equipo/";	//Me envia a la lista de equipos
	}
	 * 
	 * 
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
	}*/
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
	
