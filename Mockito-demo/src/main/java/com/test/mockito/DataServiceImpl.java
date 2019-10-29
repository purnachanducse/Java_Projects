/**
 * 
 */
package com.test.mockito;

/**
 * @author 10661300
 *
 */
public class DataServiceImpl {

	private DataService dataService;
	
	
	
	public DataServiceImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}



	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatest = Integer.MIN_VALUE;
		for(int val : data) {
			if(val>greatest) {
				greatest = val;
			}
		}
		return greatest;
	}

	
}
