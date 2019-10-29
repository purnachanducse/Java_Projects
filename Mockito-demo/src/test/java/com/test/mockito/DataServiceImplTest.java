/**
 * 
 */
package com.test.mockito;

import org.junit.Test;

/**
 * @author 10661300
 *
 */
class DataServiceImplTest {

	@Test
	void test() {
		DataServiceImpl impl = new DataServiceImpl(new DataServiceStub());
		impl.findTheGreatestFromAllData();
	}

}

class DataServiceStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {23,10,6};
	}
	
}
