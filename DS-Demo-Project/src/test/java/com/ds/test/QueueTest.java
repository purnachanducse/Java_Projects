package com.ds.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

public class QueueTest {
	
	@Test
	public void addToQueue() {
		Queue<String> queue = new LinkedBlockingQueue<String>();
		queue.offer("a");
		String element = queue.poll();
		assertThat(element).isEqualTo("a");
	}
	
	@Test
	public void AddEleButNotDelete() {
		Queue<String> queue = new LinkedBlockingQueue<String>();
		queue.offer("a");
		String ele = queue.peek();
		
		assertThat(ele).isEqualTo("a");
		assertThat(queue.isEmpty()).isFalse();
	}

}
