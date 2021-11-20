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

import com.devweb.delivery.entity.Item;
import com.devweb.delivery.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item/{id}")
	@ResponseBody
	public Item getItemById(@PathVariable Long id) {
		
		return itemService.getItemById(id);
	}
	
	@PutMapping("/item/salvar")
	public ResponseEntity<?> saveItem(@RequestBody Item item) {
		
		itemService.salvar(item);
		
		return ResponseEntity.ok("Item salvo com sucesso");
	}
	

}

//@PathVariable("id") Long id