package com.devweb.delivery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devweb.delivery.entity.Item;
import com.devweb.delivery.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Item getItemById(Long id) {
	
		Optional<Item> item = itemRepository.findById(id);
		
		if (item.isPresent()) {
			return item.get();
		}
		
		return null;
	}
	
	public Item salvar(Item item) {
		
		return itemRepository.save(item);		
	}

}