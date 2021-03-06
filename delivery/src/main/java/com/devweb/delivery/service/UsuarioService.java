package com.devweb.delivery.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devweb.delivery.entity.Usuario;
import com.devweb.delivery.exception.NotFoundException;
import com.devweb.delivery.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario getUsuarioByUuid(String uuid) {
		
		Usuario usuario = usuarioRepository.findByUuid(uuid);
		
		if (usuario == null) {
			throw new NotFoundException("Usuário não encontrado");
		}
		
		return usuario;
		
	}
	
public Usuario getUsuarioByEmail(String email) {
		
		Usuario usuario = usuarioRepository.selectByEmail(email);
		
		if (usuario == null) {
			throw new NotFoundException("Usuário não encontrado");
		}
		
		return usuario;
		
	}
	
}
