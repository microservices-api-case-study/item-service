package com.retail.services.itemservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.services.itemservice.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	public Item findByName(String name);
}
