package com.walmart.det.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.walmart.det.unittesting.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl business;

	@Mock
	SomeDataService dataServiceMock;

	@Test
	public void calculateSumFromDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3, 4 });
		assertEquals(10, business.calculateSumFromDataService());
	}

	@Test
	public void calculateSumFromDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumFromDataService());
	}

	@Test
	public void calculateSumFromDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });
		assertEquals(5, business.calculateSumFromDataService());
	}

}
