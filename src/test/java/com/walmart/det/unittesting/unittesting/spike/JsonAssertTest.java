package com.walmart.det.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	private String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":1,\"quantity\":100}";

	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\": 1,\"name\": \"Ball\",\"price\": 1,\"quantity\": 100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}

	@Test
	public void jsonAssert_StrictFalse_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\": 1,\"name\": \"Ball\"}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

	@Test
	public void jsonAssert_WithoutScapeCharacters() throws JSONException {
		String expectedResponse = "{id: 1,name:Ball}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}
