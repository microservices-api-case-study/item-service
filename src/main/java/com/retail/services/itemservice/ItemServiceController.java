package com.retail.services.itemservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class ItemServiceController {
	
	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/items")
	public List<Item> getAllItems(){
		return itemRepository.findAll();
	}
	
	@GetMapping("/items/{itemname}")
	public Item getItemByName(@PathVariable("itemname") String itemName){
		return itemRepository.findByName(itemName);
	}
}
