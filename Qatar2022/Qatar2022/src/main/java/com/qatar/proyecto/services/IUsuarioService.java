package com.qatar.proyecto.services;

import java.util.List;

import com.qatar.proyecto.entities.Usuario;

//Creo una interface para Usuario declaro los metodos a usar
public interface IUsuarioService {
	
	public List<Usuario> listarUsuarios(); //Para probar si trae los empleados con endpoints
	
	public Usuario guardar(Usuario usuario);
	
	public Usuario actualizar(Long id);
	
	public void eliminar(long id);

}
