package com.qatar.proyecto.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
	
	@Autowired
	private JavaMailSender javaMailSender;
	
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
	@Transactional //Debe hacer commit o rollback
	public int eliminarUsuario(Long id) {
		return usuarioRepository.eliminarUsuario(id);
	}

	@Override
	@Transactional //Debe hacer commit o rollback
	public int actualizarUsuario(String contrasenia, Long id) {
		return usuarioRepository.actualizarUsuario(contrasenia, id);
	}

	@Override
	public Usuario buscarEmailContrasenia(String email, String contrasenia) {
		return usuarioRepository.buscarEmailContrasenia(email, contrasenia);
	}

	@Override
	public Usuario buscarUsuarioPorId(Long id) {
		return usuarioRepository.buscarPorId(id);
	}

	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public Usuario buscarUsuarioPorEmail(String email) {
		return usuarioRepository.buscarUsuarioPorEmail(email);
	}

	@Override
	public void enviarMail(String para, String de, String mensaje) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(para);
		mail.setTo(de);
		mail.setSubject("CERTANT: envio de datos para el ingreso");
		mail.setText(mensaje); 
		
		javaMailSender.send(mail);
	}

	@Override
	public void enviarMailCambioContrasenia(String para, String de, String mensaje) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(para);
		mail.setTo(de);
		mail.setSubject("CERTANT: cambio de contrasenia exitosa");
		mail.setText(mensaje);
		
		javaMailSender.send(mail);
	}
}
