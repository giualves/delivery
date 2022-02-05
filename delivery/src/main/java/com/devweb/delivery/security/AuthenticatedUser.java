package com.devweb.delivery.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import com.devweb.delivery.entity.Usuario;
import com.devweb.delivery.exception.NotFoundException;
import com.devweb.delivery.repository.UsuarioRepository;

@Component
public class AuthenticatedUser {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public Usuario getUsuario() {
		
		Jwt jwt = (Jwt) getAuthentication().getPrincipal();
		
		Usuario usuario = usuarioRepository.findByUuid(jwt.getClaim("uuid"));
		
		if (usuario == null) {
			throw new NotFoundException("Usuário inválido");
		}
		
		return usuario;
		
	}
	
}

