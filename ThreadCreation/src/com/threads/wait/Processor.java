/**
 * 
 */
package com.threads.wait;

import java.util.Scanner;

/**
 * @author 10661300
 *
 */
public class Processor {
	
	public void produce() {
		System.out.println("Came to produce");
		synchronized (this) {
			System.out.println("Producer thread running: "+Thread.currentThread().getName());
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Resumed....");
		}
	}
	
	public void consume() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Came to consume");
		synchronized (this) {
			System.out.println("Waiting for entering a key:"+Thread.currentThread().getName());
			scanner.next();
			System.out.println("Entered a key");
			notify();
		}
	}

}
