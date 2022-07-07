package com.qatar.proyecto.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qatar.proyecto.entities.Usuario;
import com.qatar.proyecto.repositories.IUsuarioRepository;
import com.qatar.proyecto.services.IUsuarioService;

@Service
//Implemento la interface anteriormente creada y sus metodos
public class UsuarioService implements IUsuarioService{
	
	//Creo una variable de UsuarioRepository
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll(); //findAll() ya vienen preestablecidos 
	}

	@Override
	@Transactional //Debe hacer commit o rollback
	public Usuario guardar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario actualizar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarEmailContrasenia(String email, String contrasenia) {
		return usuarioRepository.buscarEmailContrasenia(email, contrasenia);
	}

}
