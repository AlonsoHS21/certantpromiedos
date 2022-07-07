package com.qatar.proyecto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.xdevapi.Result;
import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.entities.Jugador;
import com.qatar.proyecto.entities.Usuario;
import com.qatar.proyecto.services.implementation.UsuarioService;

@Controller 
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired //La anotación se usa para inyectar automáticamente dependencias del tipo especificado en el bean actual.
	@Qualifier("usuarioService") //Se usa para diferenciar las implementaciones
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String inicio(Model model) {
		List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
		model.addAttribute("usuarios", listaUsuarios);
		return "usuario/lista";		
	}
	
	@GetMapping("/ingresar")
	public String ingresar(Usuario usuario) {
		return "usuario/ingresar";
	}
	
	@PostMapping("/buscar")
	public String ingresar(@Valid @ModelAttribute Usuario usuario, Errors errores, Model model) {
		
		if(errores.hasErrors()) { //Si hay errores no hace nada
			return "usuario/ingresar";
		}
		usuario = usuarioService.buscarEmailContrasenia(usuario.getEmail(),usuario.getContrasenia()); //Por ahora busca por email
		model.addAttribute("usuarioEncontrado", "Bienvenido " + usuario.getNombre() + "!");
		return "usuario/ingresar";
		
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
	
	/*
	
	//@GetMapping es un atajo para @RequestMapping(method = RequestMethod.GET) y se utiliza para mapear HTTP GET solicitudes a los métodos de controlador asignados. 
	@GetMapping 
	public List<Usuario> listar() {
		return usuarioService.listarUsuarios();
	}
	
	@PostMapping("/save")
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
	
}
