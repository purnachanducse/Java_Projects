package com.test;

public class RemovalDuplicatesUsingIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {10,20,20,30,40,40,50};
		int size = input.length;
		int j=0;
		
		for(int i=0;i<size-1;i++) {
			if(input[i] != input[i+1]) {
				input[j++] = input[i];
			}
		}
		
		input[j++] = input[size-1];
		
		for(int i=0;i<j;i++) {
			System.out.println("---"+input[i]);
		}
	}

}
