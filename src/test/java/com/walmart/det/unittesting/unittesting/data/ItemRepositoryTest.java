package com.walmart.det.unittesting.unittesting.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository repository;
	
	
	@Test
	public void testFindAll() {
		assertEquals(4, repository.findAll().size());

	}

}
