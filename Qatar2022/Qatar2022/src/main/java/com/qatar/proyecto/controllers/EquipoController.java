package com.qatar.proyecto.controllers;

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
import com.qatar.proyecto.services.IEquipoService;
import com.qatar.proyecto.services.IJugadorService;


@Controller
@RequestMapping("/equipo")
public class EquipoController {
	
	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;
	
	@RequestMapping("/")
	public String crear(Model model) {
		Equipo equipo = new Equipo();
		model.addAttribute("equipo", equipo);
		return "equipo/crear";
	}
	
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

}
