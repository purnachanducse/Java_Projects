/**
 * 
 */
package com.spring.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 10661300
 *
 */
@Component
public class BinarySearchImpl {
	
	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	/**
	 * @param sortAlgorithm
	 */
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}


	public int sort(int[] numbers,int searchNum) {
		sortAlgorithm.sort(numbers);
		System.out.println("Using "+sortAlgorithm.getClass()+" Algorithm");
		return 3;
	}
}
