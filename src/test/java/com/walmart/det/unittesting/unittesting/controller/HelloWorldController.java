package com.walmart.det.unittesting.unittesting.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldController {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
