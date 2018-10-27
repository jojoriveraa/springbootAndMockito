package com.walmart.det.unittesting.unittesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.det.unittesting.unittesting.business.ItemBusinessService;
import com.walmart.det.unittesting.unittesting.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 1, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return businessService.retriveHardCodedItem();
    }

}