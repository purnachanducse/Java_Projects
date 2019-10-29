package com.ds.test;

import java.util.Stack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DsDemoProjectApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DsDemoProjectApplication.class, args);
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("a");
	}

}
