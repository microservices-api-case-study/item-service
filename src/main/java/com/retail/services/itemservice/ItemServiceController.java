package com.retail.services.itemservice;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.services.itemservice.model.Item;
import com.retail.services.itemservice.repos.ItemRepository;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/service2")
@RefreshScope
public class ItemServiceController {
	
	private static final Logger log = LoggerFactory.getLogger(ItemServiceController.class);
	
	@Value("${app.custom.message}")
	String message;
	
	@Autowired
	Environment environment;
	
	@Autowired
	ItemRepository itemRepository;

	/**
	 * This operation returns the details of all the Items
	 * @return List<Item>
	 */
	@GetMapping("/items")
	public List<Item> getAllItems(){
		log.info(message);
		log.info(displayEnvInfo());
		return itemRepository.findAll();
	}
	
	/**
	 * This operation returns the details of a specific item 
	 * matching the itemname provided as an input. 
	 * If the requested item is not present then it returns an empty response.
	 * @return Item
	 */
	
	@GetMapping("/items/{itemname}")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request format") })
	public Item getItemByName(@ApiParam(value="Item Name\n Examples: Pen, Book", required=true) 
			@Valid @NotNull @NotBlank @PathVariable("itemname") String itemName){
		log.info(displayEnvInfo());
		return itemRepository.findByName(itemName);
	}
	
	private String displayEnvInfo() {
		return "Request received by item-service instance running at"
				+ " || IP: " +environment.getProperty("spring.cloud.client.ip-address")
				+ " || Host: " +environment.getProperty("spring.cloud.client.hostname")
				+ " || Port: "+environment.getProperty("local.server.port");
	}
}
