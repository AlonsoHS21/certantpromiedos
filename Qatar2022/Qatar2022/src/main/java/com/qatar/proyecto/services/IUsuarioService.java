package com.qatar.proyecto.services;

import java.util.List;

import com.qatar.proyecto.entities.Usuario;

//Creo una interface para Usuario declaro los metodos a usar
public interface IUsuarioService {
	
	public List<Usuario> listarUsuarios(); //Para probar si trae los empleados con endpoints
	
	public void guardar(Usuario usuario);
	
	public void eliminar(long id); 
}
