package com.walmart.det.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {

	List<String> mock = mock(List.class);

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void size_returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	public void size_returnWithParams() {
		when(mock.get(0)).thenReturn("gtsmxdet");
		assertEquals("gtsmxdet", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	public void size_returnWithGenericParams() {
		when(mock.get(anyInt())).thenReturn("gtsmxdet");
		assertEquals("gtsmxdet", mock.get(0));
		assertEquals("gtsmxdet", mock.get(1));
	}

	@Test
	public void verification_basic() {
		// SUT
		String value = mock.get(0);

		// Verify
		verify(mock).get(0);
		verify(mock).get(anyInt());
		verify(mock, times(1)).get(anyInt());
	}

	@Test
	public void verification_callTwice() {
		// SUT
		String value1 = mock.get(0);
		String value2 = mock.get(1);

		// Verify
		verify(mock).get(0);
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}

	@Test
	public void verification_argsCapturing() {
		// SUT
		mock.add("element");

		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());

		assertEquals("element", captor.getValue());
	}

	@Test
	public void verification_multipleArgsCapturing() {
		// SUT
		mock.add("element A");
		mock.add("element B");

		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());

		List<String> allValues = captor.getAllValues();
		assertEquals("element A", allValues.get(0));
		assertEquals("element B", allValues.get(1));
	}

	@Test
	public void spying_basic() {
		ArrayList<String> arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("element0");
		System.out.println(arrayListSpy.get(0));
		System.out.println(arrayListSpy.size());
		arrayListSpy.add("element1");
		arrayListSpy.add("element2");
		System.out.println(arrayListSpy.size());

		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());

		arrayListSpy.add("element3");
		System.out.println(arrayListSpy.size());

		verify(arrayListSpy).add("element3");
	}

}
