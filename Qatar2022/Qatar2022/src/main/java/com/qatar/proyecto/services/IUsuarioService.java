package com.qatar.proyecto.services;

import java.util.List;

import com.qatar.proyecto.entities.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> getAll(); //Para probar si trae los empleados con endpoints
	
	public void guardar(Usuario usuario);
	
	public void eliminar(long id); 
}
