package com.qatar.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qatar.proyecto.entities.Apuesta;
import com.qatar.proyecto.services.IApuestaService;
import com.qatar.proyecto.services.IUsuarioService;

@Controller
@RequestMapping("/apuesta")
public class ApuestaController {

	@Autowired
	@Qualifier("apuestaService")
	private IApuestaService apuestaService;
	
	@Autowired
	@Qualifier("usuarioService") 
	private IUsuarioService usuarioService;
	
	
	/* ----------------- LISTAR APUESTAS ----------------- */
	
	@GetMapping("/")
	public String lista(
			Model model
			) {
		List<Apuesta> listaDeApuestas = apuestaService.getAll();
		model.addAttribute("apuestas", listaDeApuestas);
		return "apuesta/lista";
	}
}
