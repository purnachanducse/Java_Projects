/**
 * 
 */
package com.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author 10661300
 *
 */
@RunWith(MockitoJUnitRunner.class)
class DataServiceImplMockitoAnnotationsTest {
	
	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	DataServiceImpl dataServiceImpl;

	@Test
	void testForGreatestVal() {
		//DataService mock2 = mock(DataService.class);
		//when(mock2.retrieveAllData()).thenReturn(new int[] {24,12,27});
		//DataServiceImpl impl = new DataServiceImpl(mock2);
		//int gre = impl.findTheGreatestFromAllData();
		//assertEquals(27, gre);
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,12,27});
		assertEquals(27, dataServiceImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void testtestForGreatestOneVal() {
		//DataService mock2 = mock(DataService.class);
		//when(mock2.retrieveAllData()).thenReturn(new int[] {24});
		//DataServiceImpl impl = new DataServiceImpl(mock2);
		//int gre = impl.findTheGreatestFromAllData();
		//assertEquals(24, gre);
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24});
		assertEquals(24, dataServiceImpl.findTheGreatestFromAllData());
	}

}
	
