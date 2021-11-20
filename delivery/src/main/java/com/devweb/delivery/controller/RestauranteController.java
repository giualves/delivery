package com.devweb.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devweb.delivery.entity.Restaurante;
import com.devweb.delivery.service.RestauranteService;

@Controller
public class RestauranteController {
	
	@Autowired
	private RestauranteService restauranteService;
	
	@GetMapping("/restaurantes/{id}")
	@ResponseBody
	public Restaurante getRestauranteById(@PathVariable Long id) {
		
		return restauranteService.getRestauranteById(id);		
		
	}
	
	@PutMapping("/restaurantes/{id}")
	
	
	
	public ResponseEntity<?> atualizaNome(
		@PathVariable("id") Long id,
		@RequestBody Restaurante rest){
		
		restauranteService.salvarNome(id, rest);
		
		return ResponseEntity.ok("Registro alterado com sucesso");
		
	}	

	
}
