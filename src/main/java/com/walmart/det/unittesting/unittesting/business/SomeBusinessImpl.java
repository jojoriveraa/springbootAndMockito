package com.walmart.det.unittesting.unittesting.business;

import java.util.Arrays;

public class SomeBusinessImpl {
	
	public int calculateSum(int [] data) {
		return Arrays.stream(data).sum();
	}

}
