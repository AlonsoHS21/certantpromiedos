package com.qatar.proyecto.services;

import java.util.List;

import com.qatar.proyecto.entities.Usuario;

//Creo una interface para Usuario declaro los metodos a usar
public interface IUsuarioService {
	
	public List<Usuario> listarUsuarios(); //Para probar si trae los empleados con endpoints
	
	public Usuario guardar(Usuario usuario);
	
	public int actualizarUsuario(String contrasenia, Long id); //Un usuario solo modifica la contrasenia
	
	public int eliminarUsuario(Long id);
	
	public Usuario buscarEmailContrasenia(String email,String contrasenia);

	public Usuario buscarUsuarioPorId(Long id);
	
	public void save(Usuario usuario);
	
	public Usuario buscarUsuarioPorEmail(String email);
	
	public void enviarMail (String para, String de, String mensaje);
	
	public void enviarMailCambioContrasenia (String para, String de, String mensaje);
}
