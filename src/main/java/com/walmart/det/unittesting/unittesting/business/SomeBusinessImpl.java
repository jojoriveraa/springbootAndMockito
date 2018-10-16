package com.walmart.det.unittesting.unittesting.business;

import java.util.Arrays;

import com.walmart.det.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService dataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.dataService = someDataService;
	}

	public int calculateSum(int[] data) {
		return Arrays.stream(data).sum();
	}

	public int calculateSumFromDataService() {
		int data[] = dataService.retriveAllData();
		return calculateSum(data);
	}

}
