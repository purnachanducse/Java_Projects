/**
 * 
 */
package com.threads.lowLevelSynchronization;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author 10661300
 *
 */
public class Processor {

	private LinkedList<Integer> linkedList = new LinkedList<Integer>();
	private final int LIMIIT = 10;
	private Object lock = new Object();

	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (lock) {
				while (linkedList.size() == LIMIIT) {
					System.out.println("Thread in produce() method in lock: " + Thread.currentThread().getName());
					lock.wait();
				}
				System.out.println(
						"Thread in produce() method before adding to list: " + Thread.currentThread().getName());
				linkedList.add(value++);
				lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException {
		Random random = new Random();
		while (true) {
			synchronized (lock) {
				while (linkedList.size() == 0) {
					System.out.println("Thread in consume() method in lock: " + Thread.currentThread().getName());
					lock.wait();
				}
				System.out.println(
						"List size is: " + linkedList.size() + "Before removing " + Thread.currentThread().getName());
				int val = linkedList.removeFirst();
				System.out.println("Value is: " + val);
				lock.notify();
			}
			Thread.sleep(random.nextInt(1000));
		}

	}

}
