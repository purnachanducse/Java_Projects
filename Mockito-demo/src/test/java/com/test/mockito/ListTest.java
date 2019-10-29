/**
 * 
 */
package com.test.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author 10661300
 *
 */
class ListTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		List mock2 = mock(List.class);
		when(mock2.size()).thenReturn(10);
		assertEquals(10, mock2.size());
	}

}
