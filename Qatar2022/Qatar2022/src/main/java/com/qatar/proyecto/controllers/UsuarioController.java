package com.qatar.proyecto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qatar.proyecto.entities.Apuesta;
import com.qatar.proyecto.entities.Usuario;
import com.qatar.proyecto.services.IApuestaService;
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
	
	/* ----------------- LISTAR USUARIOS ----------------- */
	
	@GetMapping("/usuario")
	public String lista(Model model) {
		List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
		model.addAttribute("usuarios",listaUsuarios);
		return "usuario/lista";
	}
	
	/* ----------------- LISTAR USUARIOS x APUESTA ----------------- */
	
	@GetMapping("usuario/listarApuestas/{id}")
	public String listaApuestasPorUsuario(
			@PathVariable Long id,
			Model model
			) {
		List<Apuesta> listaApuestas = apuestaService.buscarApuestasPorIdUsuario(id);
		model.addAttribute("listaApuestasPorUsuario", listaApuestas);
		model.addAttribute("usuario", usuarioService.buscarUsuarioPorId(id));
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
			Model model
			) {
		usuario.setPuntos(0);
		usuarioService.save(usuario);
		return "redirect:/usuario/";
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
		
		boolean errores = result.hasErrors();
		if(errores) {
			model.addAttribute("usuario", usuario);
			return "usuario/ingresar";
		}
		usuario = usuarioService.buscarEmailContrasenia(usuario.getEmail(), usuario.getContrasenia());
		if(usuario != null) { //Si encontro el usuario no viene nulo
			return "redirect:/home"; //Me envia a home
		}  
		redirect.addFlashAttribute("info","Email o contraseña incorrecta");
		return "redirect:/"; //Se queda en la misma pagina
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
		return "redirect:/usuario/";
	}
}
		/*
		@PostMapping("/")
		public String guardar(@Valid @ModelAttribute Usuario usuario,BindingResult result, Model model, RedirectAttributes attribute ) {

			if(result.hasErrors()) {
				System.out.println("Hubo error en el formulario!");
				return "usuario/crear";
			}
			usuarioService.guardar(usuario);
			System.out.println("Usuario guardado con exito!");
			attribute.addFlashAttribute("success","Usuario creado con exito");
			return "redirect:/usuario/";
		
		
		 */
	
	
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


