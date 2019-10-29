/**
 * 
 */
package com.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;


/**
 * @author 10661300
 *
 */
class DataServiceImplMockitoTest {

	@Test
	void testForGreatestVal() {
		DataService mock2 = mock(DataService.class);
		when(mock2.retrieveAllData()).thenReturn(new int[] {24,12,27});
		DataServiceImpl impl = new DataServiceImpl(mock2);
		int gre = impl.findTheGreatestFromAllData();
		assertEquals(27, gre);
	}
	
	@Test
	void testtestForGreatestOneVal() {
		DataService mock2 = mock(DataService.class);
		when(mock2.retrieveAllData()).thenReturn(new int[] {24});
		DataServiceImpl impl = new DataServiceImpl(mock2);
		int gre = impl.findTheGreatestFromAllData();
		assertEquals(24, gre);
	}

}
	
