package com.ds.test;

import java.util.Arrays;

public class TimeComplexity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] intArr = {1,2,3,4};
		
		unitTime(intArr);
		nTime(intArr);
		nSquareTimes(intArr);
	}
	
	//O(1)
	public static void unitTime(int[] arrOfItems) {
		System.out.println(arrOfItems[0]);
	}
	
	//O(n)
	public static void nTime(int[] arrOfItems) {
		for(int item: arrOfItems) {
			System.out.println("item: "+item);
		}
	}
	
	//O(n^2)
	public static void nSquareTimes(int[] arrOfItems) {
		for(int firstItem: arrOfItems) {
			for(int secItem:arrOfItems) {
					int[] orderedPair = new int[] {firstItem,secItem};
					System.out.println(Arrays.toString(orderedPair));
			}
		}
	}

}
