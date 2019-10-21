/**
 * 
 */
package com.test;

/**
 * @author 10661300
 *
 */
public class RemoveDuplicatesFromArrayUsingTempArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] input = new int[]{4,3,4,7,8,3};
		int[] input = new int[]{3,4,4,7,8,8};
		int size = input.length;
		int[] temp = new int[size];
		int j=0;
		//Sorting an array
		for(int i=0;i<size-1;i++) {
			if(input[i] != input[i+1]) {
				temp[j++] = input[i];
			}
		}
		temp[j++] = input[size-1];
		for(int i=0;i<j;i++) {
			input[i]=temp[i];
			System.out.println("Result Array: "+input[i]);
		}

	}

}
