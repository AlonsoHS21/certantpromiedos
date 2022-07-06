package com.qatar.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qatar.proyecto.entities.Usuario;
import com.qatar.proyecto.services.implementation.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) // es un protocolo estándar que define la interacción entre un navegador y un servidor para manejar de forma segura las solicitudes HTTP de origen cruzado.
@RestController //Es en esencia una combinacion de @Controller y @ResponseBody
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired //La anotación se usa para inyectar automáticamente dependencias del tipo especificado en el bean actual.
	@Qualifier("usuarioService") //Se usa para diferenciar las implementaciones
	private UsuarioService usuarioService;
	
	
	//@GetMapping es un atajo para @RequestMapping(method = RequestMethod.GET) y se utiliza para mapear HTTP GET solicitudes a los métodos de controlador asignados. 
	@GetMapping("/listaUsuarios") 
	public List<Usuario> listar() {
		return usuarioService.listarUsuarios();
	}
	
	@PostMapping 
	public Usuario agregar(@RequestBody Usuario usuario) {
		return usuarioService.guardar(usuario);
	}
	
	
	
/* Links Utiles para las anotaciones
 *  https://ricardogeek.com/spring-boot-y-la-anotacion-crossorigin/
 *  https://pharos.sh/controller-y-restcontroller-anotaciones-en-spring-boot/
 *  https://www.arquitecturajava.com/spring-qualifier-utilizando-autowired/
 *  https://mvitinnovaciontecnologica.wordpress.com/2020/02/06/guia-de-anotaciones-de-spring-framework/
 *  https://gustavopeiretti.com/estructura-de-paquetes-spring-boot/
 *  Nota: @ResponseBody Cuando los controladores de solicitudes devuelven datos, como return repository.findById(), la respuesta se serializará en JSON antes de devolverse al cliente.
 * */
	
}
