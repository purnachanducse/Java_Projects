package com.spring.basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.spring.*")
public class SpringIn5StepsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsApplication.class, args);
		BinarySearchImpl binarySearchImpl = applicationContext.getBean(BinarySearchImpl.class);
		
		//BinarySearchImpl binarySearchImpl = new BinarySearchImpl((SortAlgorithm) new QuickSortAlgorithm());
		int result = binarySearchImpl.sort(new int[] {124,9}, 3);
		System.out.println("Result: "+result);
	}

}
