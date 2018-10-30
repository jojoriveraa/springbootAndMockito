package com.walmart.det.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.walmart.det.unittesting.unittesting.data.ItemRepository;
import com.walmart.det.unittesting.unittesting.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	ItemBusinessService itemBusinessService;

	@Mock
	ItemRepository itemRepositoryMock;

	@Test
	public void retriveAllItems_basic() {
		List<Item> expectedList = Arrays.asList(
				new Item(2, "Item2", 10, 10), 
				new Item(3, "Item3", 20, 20)
		);
		when(itemRepositoryMock.findAll()).thenReturn(expectedList);
		assertEquals(expectedList, itemBusinessService.retrieveAllItems());
	}

	@Test
	public void retriveAllItems_emptyDB() {
		List<Item> expectedList = Arrays.asList();
		when(itemRepositoryMock.findAll()).thenReturn(expectedList);
		assertEquals(expectedList, itemBusinessService.retrieveAllItems());
	}

	@Test
	public void retriveAllItems_oneValue() {
		List<Item> expectedList = Arrays.asList(
				new Item(1001, "Item1", 10, 10)
		);
		when(itemRepositoryMock.findAll()).thenReturn(expectedList);
		assertEquals(expectedList, itemBusinessService.retrieveAllItems());
	}
	
	@Test
	public void retriveAllItems_calculateValue() {
		List<Item> expectedList = Arrays.asList(
				new Item(2, "Item2", 10, 10), 
				new Item(3, "Item3", 20, 20)
		);
		when(itemRepositoryMock.findAll()).thenReturn(expectedList);
		List<Item> items = itemBusinessService.retrieveAllItems();
		assertEquals(100, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());
	}

}
