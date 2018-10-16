package com.walmart.det.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.walmart.det.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessStubTest {

	@Test
	public void calculateSumFromDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceStub = new SomeDataService() {
			@Override
			public int[] retriveAllData() {
				return new int[] { 1, 2, 3, 4 };
			}
		};

		business.setSomeDataService(dataServiceStub);
		int actualResult = business.calculateSumFromDataService();
		int expectedResult = 10;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumFromDataService_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceStub = new SomeDataService() {
			@Override
			public int[] retriveAllData() {
				return new int[] { };
			}
		};

		business.setSomeDataService(dataServiceStub);
		int actualResult = business.calculateSumFromDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumFromDataService_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceStub = new SomeDataService() {
			@Override
			public int[] retriveAllData() {
				return new int[] { 5 };
			}
		};

		business.setSomeDataService(dataServiceStub);
		int actualResult = business.calculateSumFromDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}

}
