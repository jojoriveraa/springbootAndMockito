package com.walmart.det.unittesting.unittesting.business;

import org.springframework.stereotype.Component;

import com.walmart.det.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessService {

	public Item retriveHardCodedItem() {
		Item item = new Item(1, "Ball", 1, 100);
		return item;
	}

}
