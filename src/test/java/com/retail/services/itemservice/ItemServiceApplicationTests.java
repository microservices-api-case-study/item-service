package com.retail.services.itemservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.retail.services.itemservice.model.Item;

@ActiveProfiles("junit")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ItemServiceApplicationTests {

	private static String URL_PREFIX = "http://localhost:";

	@LocalServerPort
	private int port;

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	void testGetAllItems() {

		ResponseEntity<List<Item>> response = testRestTemplate.exchange(URL_PREFIX + port + "/service2/items",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Item>>() {
				});
		List<Item> items = response.getBody();
		assertEquals(2, items.size());
		assertEquals("Book", items.get(0).getName());

	}

	@Test
	void testGetItemByName() {

		String itemName = "Pen";
		ResponseEntity<Item> response = testRestTemplate.exchange(URL_PREFIX + port + "/service2/items/" + itemName,
				HttpMethod.GET, null, new ParameterizedTypeReference<Item>() {
				});
		Item item = response.getBody();
		assertEquals("Pen", item.getName());

	}

}
