package com.walmart.det.unittesting.unittesting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void dummyItemAsString_basic() throws Exception {
		// call "/hello-world"
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		// Do request and verify "Hello world"
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":1,\"quantity\":100}"))
				.andReturn();
		
		// assertEquals("Hello world", result.getResponse().getContentAsString());
	}
	
	@Test
	public void dummyItemAsJSON_basic() throws Exception {
		// call "/hello-world"
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		// Do request and verify "Hello world"
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":1,\"quantity\":100}"))
				.andReturn();
		
		// assertEquals("Hello world", result.getResponse().getContentAsString());
	}

}
