package com.walmart.det.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.det.unittesting.unittesting.model.Item;


public interface ItemRepository extends JpaRepository<Item, Integer>{

}
