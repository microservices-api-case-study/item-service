package com.retail.services.itemservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class ItemServiceController {
	
	private static final Logger log = LoggerFactory.getLogger(ItemServiceController.class);
	
	@Autowired
	Environment environment;
	
	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/items")
	public List<Item> getAllItems(){
		log.info(displayEnvInfo());
		return itemRepository.findAll();
	}
	
	@GetMapping("/items/{itemname}")
	public Item getItemByName(@PathVariable("itemname") String itemName){
		log.info(displayEnvInfo());
		return itemRepository.findByName(itemName);
	}
	
	private String displayEnvInfo() {
		return "Request received by Item Service running at Port# "+environment.getProperty("local.server.port");
	}
}
