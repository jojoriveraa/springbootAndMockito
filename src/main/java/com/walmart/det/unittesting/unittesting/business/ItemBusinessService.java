package com.walmart.det.unittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.walmart.det.unittesting.unittesting.data.ItemRepository;
import com.walmart.det.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessService {

	@Autowired
	private ItemRepository repository;
	
	public Item retriveHardCodedItem() {
		Item item = new Item(1, "Ball", 1, 100);
		return item;
	}

	public List<Item> retrieveAllItems() {
		List<Item> items = repository.findAll();
		items.stream().forEach(i -> i.setValue(i.getPrice() * i.getQuantity()));
		return items;
	}

}
