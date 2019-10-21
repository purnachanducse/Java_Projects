package com.test;

public class RemoveDuplicatesFromUnsortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {50,20,40,10,20,30,40};
		int size = input.length;
		int j=0,temp=0;
		
		for(int i=0;i<size;i++) {
			for(int j1=i+1;j1<size;j1++) {
				if(input[i] > input[j1]) {
					temp = input[i];
					input[i] = input[j1];
					input[j1] = temp;
				}
			}
		}
		
		for(int i=0;i<j;i++) {
			System.out.println("1---"+input[i]);
		}
		
		for(int i=0;i<size-1;i++) {
			if(input[i] != input[i+1]) {
				input[j++] = input[i];
			}
		}
		input[j++] = input[size-1];
		
		for(int i=0;i<j;i++) {
			System.out.println("2---"+input[i]);
		}
		
//		for(int i=0;i<size;i++) {
//			System.out.println("2---"+input[i]);
//		}
	}
}
