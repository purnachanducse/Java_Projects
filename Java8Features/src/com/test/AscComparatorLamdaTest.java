package com.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AscComparatorLamdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> arrayList= new ArrayList<>();
		arrayList.add(20);
		arrayList.add(30);
		arrayList.add(50);
		arrayList.add(10);
		arrayList.add(40);
		System.out.println("List: "+arrayList);
		//Collections.sort(arrayList, new AscComparator());
		Comparator<Integer> comparator = (I1,I2)->(I1<I2)?-1:(I1>I2)?1:0;
		Collections.sort(arrayList, comparator);
		//System.out.println("List: "+arrayList);
		arrayList.stream().forEach(System.out::println);
		
		List<Integer> evenList = arrayList.stream().filter(i->i%2==0).collect(Collectors.toList());
		
		evenList.stream().forEach(System.out::println);
	}

}
