package com.ds.test;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;

import org.junit.Test;

public class StackTest {
	@Test
	public void pushStack() {
		Stack<String> stack = new Stack<String>();
		stack.push("a");
		assertThat(stack.size()).isEqualTo(1);
		
		String element = stack.pop();
		assertThat(element).isEqualTo("a");
		assertThat(stack.isEmpty()).isTrue();
	}
	
	@Test
	public void popStackCheck() {
		Stack<String> stack = new Stack<String>();
		
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		assertThat(stack.pop()).isEqualTo("a");
	}
	
	@Test
	public void peekStack() {
		Stack<String> stack = new Stack<String>();
		stack.push("a");
		assertThat(stack.peek()).isEqualTo("a");
	}
}
