package com.devweb.delivery.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devweb.delivery.entity.Restaurante;
import com.devweb.delivery.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public Restaurante getRestauranteById(Long id) {
		
		Optional<Restaurante> restaurante = restauranteRepository.findById(id); 
		
		if (restaurante.isPresent()) {
			return restaurante.get();
		}
		
		return null;
	}
	
	public Restaurante salvarNome(Long id, Restaurante rest) {
		
		Restaurante restUpdate = restauranteRepository.findById(id).get();
		if (rest.getNome() != null) {
			restUpdate.setNome(rest.getNome());
		};
		if (rest.getTaxaFrete() != null) {
			restUpdate.setTaxaFrete(rest.getTaxaFrete());	
		}		

		return restauranteRepository.save(restUpdate);
	}

}
