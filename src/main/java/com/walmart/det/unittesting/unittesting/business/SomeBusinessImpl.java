package com.walmart.det.unittesting.unittesting.business;

import java.util.Arrays;

import com.walmart.det.unittesting.unittesting.data.SomeDataService;

class SomeBusinessImpl {

	private SomeDataService dataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.dataService = someDataService;
	}

	public int calculateSum(int[] data) {
		//alternatively you can use => Arrays.stream(data).reduce(Integer::sum);
		return Arrays.stream(data).sum();
	}

	public int calculateSumFromDataService() {
		return Arrays.stream(dataService.retrieveAllData()).sum();
	}

}
