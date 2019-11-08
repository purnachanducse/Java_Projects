package com.test;

import java.util.Comparator;

public class AscComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer I1, Integer I2) {
		// TODO Auto-generated method stub
//		if(I1<I2) {
//			return -1;
//		}else if(I1>I2) {
//			return 1;
//		}else {
//			return 0;
//		}
		
		//Using ternary operator
		return (I1<I2)?-1:(I1>I2)?1:0;
		
		//Lamda expression
		//(I1,I2)->(I1<I2)?-1:(I1>I2)?1:0;
	}
}
