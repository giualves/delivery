package com.devweb.delivery.service;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devweb.delivery.entity.Restaurante;
import com.devweb.delivery.exception.NotFoundException;
import com.devweb.delivery.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public List<Restaurante> listarTodosOsRestaurantes() {
		
		return restauranteRepository.findAll();
		
	}
	
	public Restaurante getRestauranteByUuid(String uuid) {
		
		Restaurante restaurante = restauranteRepository.findByUuid(uuid);
		
		if (restaurante == null) {
			throw new NotFoundException("Restaurante não encontrado");
		}
		
		return restaurante;
		
	}

	public Restaurante getRestauranteById(Long id) {
		Restaurante rest = restauranteRepository.getById(id);
		if (rest == null) {
			throw new NotFoundException("Restaurante não encontrado");
		}
		
		return rest;		
	}
	
	
	public Restaurante salvar(Restaurante restaurante) {
		
		return restauranteRepository.save(restaurante);
		
	}
	
	public Restaurante alterar(String uuid, Restaurante restaurante) {
		
		Restaurante restauranteAtual = this.getRestauranteByUuid(uuid);
		
		if (restauranteAtual != null) {
			
			//restauranteAtual = null;
			
			BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "uuid");
			
			return restauranteRepository.save(restauranteAtual);
			
		}
		
		return null;
		
	}
	
	public boolean excluir(String uuid) {
		
		Restaurante restaurante = this.getRestauranteByUuid(uuid);
		
		if (restaurante != null) {
			
			try {
		
				restauranteRepository.delete(restaurante);
				
				return true;
				
			} catch (EmptyResultDataAccessException ex) {
				
				System.out.println(ex.getMessage());
				
			}
			
		}
		
		return false;
		
	}
	
}
