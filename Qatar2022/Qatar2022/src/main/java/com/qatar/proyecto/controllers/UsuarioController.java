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

import com.qatar.proyecto.entities.Apuesta;
import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.entities.Jackpot;
import com.qatar.proyecto.entities.Jugador;
import com.qatar.proyecto.entities.Usuario;
import com.qatar.proyecto.services.IApuestaService;
import com.qatar.proyecto.services.IEquipoService;
import com.qatar.proyecto.services.IJackpotService;
import com.qatar.proyecto.services.IJugadorService;
import com.qatar.proyecto.services.implementation.UsuarioService;


@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioService") 
	private UsuarioService usuarioService;
	
	@Autowired
	@Qualifier("apuestaService")
	private IApuestaService apuestaService;
	
	@Autowired
	@Qualifier("jackpotService")
	private IJackpotService jackpotService;
	
	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;
	
	@Autowired
	@Qualifier("jugadorService")
	private IJugadorService jugadorService;
	
	/* ----------------- LISTAR USUARIOS ----------------- */
	
	@GetMapping("/usuario")
	public String lista(Model model) {
		List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
		if(!listaUsuarios.isEmpty()) {
			model.addAttribute("usuarios",listaUsuarios);
			return "usuario/lista";
		}
		model.addAttribute("info", "No se encontraron usuario para listar");
		return "usuario/lista";
	}
	
	/* ----------------- LISTAR USUARIOS x APUESTA ----------------- */
	
	@GetMapping("usuario/listarApuestas/{id}")
	public String listaApuestasPorUsuario(
			@PathVariable Long id,
			RedirectAttributes redirect,
			Model model
			) {
		List<Apuesta> listaApuestas = apuestaService.buscarApuestasPorIdUsuario(id);
		if(!listaApuestas.isEmpty()) {
			Jackpot jackpot = jackpotService.buscarJackpotPorIdUsuario(id);
			if(jackpot != null) {
				List<Equipo> listaEquipos = equipoService.getAll();
				List<Jugador> listaJugadores = jugadorService.getAll();
				model.addAttribute("apuestasPorUsuario", listaApuestas);
				model.addAttribute("jackpot", jackpot);
				model.addAttribute("jugadores", listaJugadores);
				model.addAttribute("equipos", listaEquipos);
				model.addAttribute("usuario", usuarioService.buscarUsuarioPorId(id));
				return "apuesta/lista";
			}
			List<Equipo> listaEquipos = equipoService.getAll();
			List<Jugador> listaJugadores = jugadorService.getAll();
			model.addAttribute("apuestasPorUsuario", listaApuestas);
			model.addAttribute("jugadores", listaJugadores);
			model.addAttribute("equipos", listaEquipos);
			model.addAttribute("usuario", usuarioService.buscarUsuarioPorId(id));
			model.addAttribute("info", "No se encontraron jackpots para el usuario");
			return "apuesta/lista";
		}
		model.addAttribute("info", "No se encontraron apuestas para el usuario");
		return "apuesta/lista";
	}
	
	/* ----------------- CREAR USUARIO ----------------- */
	
	@GetMapping("usuario/agregar")
	public String redirigirCrear(
			Usuario usuario,
			Model model
			) {
		model.addAttribute("usuario", usuario);
		return "usuario/crear";
	}
	
	@PostMapping("/guardar")
	public String guardar(
			Usuario usuario,
			Model model,
			RedirectAttributes redirect
			) {
		usuario.setPuntos(0);
		usuarioService.save(usuario);
		System.out.println("Usuario guardado con exito!");
		redirect.addFlashAttribute("save", "Usuario guardado con exito!");
		return "redirect:/usuario/agregar";
	}
	
	/* ----------------- INGRESAR USUARIOS ----------------- */
	
	@GetMapping("/")
	public String ingresar(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "usuario/ingresar";
	}
	
	@PostMapping("/buscar")
	public String buscar(
			@Valid Usuario usuario,
			BindingResult result,
			RedirectAttributes redirect,
			Model model
			) {
		/* ****************** ERRORES ****************** */
		if(result.hasErrors()) {
			model.addAttribute("usuario", usuario);
			System.out.println("ERROR: Hubo un error en el formulario de ingresar usuario");
			return "usuario/ingresar";
		}
		/* ****************** GUARDA UN JUGADOR ****************** */
		usuario = usuarioService.buscarEmailContrasenia(usuario.getEmail(), usuario.getContrasenia());
		if(usuario != null) { 
			return "redirect:/home"; 
		}  
		redirect.addFlashAttribute("info","INFO: Email o contraseña incorrecta");
		return "redirect:/";
	}
	
	/* ----------------- EDITAR USUARIOS ----------------- */
	@GetMapping("/usuario/editar/{id}")
	public String redirigirEditar(
			@PathVariable Long id,
			Model model
			) {
		model.addAttribute("usuario", usuarioService.buscarUsuarioPorId(id));
		return "usuario/editar";
	}
	
	@PostMapping("/usuario/editar/{id}")
	public String editar(
			@PathVariable Long id,
			@ModelAttribute("usuario") Usuario usuario,
			Model model
			) {
		Usuario usuarioEncontrado = usuarioService.buscarUsuarioPorId(id);
		if(usuarioEncontrado != null) {
			usuarioService.actualizarUsuario(usuario.getContrasenia(), id);
			return "redirect:/usuario/";
		}
		return "usuario/editar/{id}";
	}
	
	/* ----------------- ELIMINAR USUARIOS ----------------- */
	@GetMapping("/usuario/eliminar/{id}")
	public String eliminar(
			@PathVariable Long id
			) {
		usuarioService.eliminarUsuario(id);
		apuestaService.eliminarApuestasPorUsuario(id);
		return "redirect:/usuario/";
	}
}

	
/* Links Utiles para las anotaciones
 *  https://ricardogeek.com/spring-boot-y-la-anotacion-crossorigin/
 *  https://pharos.sh/controller-y-restcontroller-anotaciones-en-spring-boot/
 *  https://www.arquitecturajava.com/spring-qualifier-utilizando-autowired/
 *  https://mvitinnovaciontecnologica.wordpress.com/2020/02/06/guia-de-anotaciones-de-spring-framework/
 *  https://gustavopeiretti.com/estructura-de-paquetes-spring-boot/
 *  Nota: @ResponseBody Cuando los controladores de solicitudes devuelven datos, como return repository.findById(), la respuesta se serializará en JSON antes de devolverse al cliente.
 * */
	
	


/* ----------------------------- SWAGGR ----------------------------- */

/*
@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired //La anotación se usa para inyectar automáticamente dependencias del tipo especificado en el bean actual.
	@Qualifier("usuarioService") //Se usa para diferenciar las implementaciones
	private UsuarioService usuarioService;

	//GET ALL
	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> listaUsuario() {
		List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
		
		if(listaUsuarios != null) {
			return ResponseEntity.ok(listaUsuarios);
		} else {
			return new ResponseEntity<List<Usuario>>(HttpStatus.EXPECTATION_FAILED); 
		}
	}
	
	//POST
	@PostMapping
	public ResponseEntity<Usuario> ingresar(@RequestBody Usuario usuario) {
		
		usuario = usuarioService.buscarEmailContrasenia(usuario.getEmail(), usuario.getContrasenia()); //busca y me trae usuario y contra
		
		if(usuario == null) { //Si no trajo nada
			return new ResponseEntity<Usuario>(HttpStatus.EXPECTATION_FAILED);
		} else { //No hace falta el else
			return ResponseEntity.ok(usuario); //Devuelve 200 porque encontro el usuario
		}
	}
	
	//PUT
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> actualizarUsuario(
			@PathVariable(value = "id") Long id,
			@RequestBody Usuario usuario)
	{
		Usuario usuarioEncontrado = usuarioService.buscarUsuarioPorId(id); //Busco para ver si existe el usuario
		
		if(usuarioEncontrado != null) {
			
			int rows = usuarioService.actualizarUsuario(usuario.getContrasenia(),id);
			
			if(rows > 0 ) {
				return new ResponseEntity<Usuario>(HttpStatus.CREATED); //Se modifico correctamente
			}else {
				return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR); //Hubo un error y la solicitud no pude ser completada
			}
		}
		return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST); //Envia un 400 sintaxis invalida o que no existe el usuario
	}
	
	//DELETE
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Usuario> eliminarUsuario(
			@PathVariable(value = "id") Long id)
	{		
			int rows = usuarioService.eliminarUsuario(id);
			
			if(rows > 0) {
				return new ResponseEntity<Usuario>(HttpStatus.CREATED); //Se modifico correctamente
			}else {
				return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR); //Hubo un error y la solicitud no pude ser completada
			}
	}
}*/


