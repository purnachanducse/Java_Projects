/**
 * 
 */
package com.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 10661300
 *
 */
public class MultipleLocks {

	private static Random random = new Random();

	private static Object  obj1 = new Object();
	private static Object  obj2 = new Object();
			
	private static List<Integer> list1 = new ArrayList<Integer>();
	private static List<Integer> list2 = new ArrayList<Integer>();

	public static void stageOne() {
		synchronized (obj1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
			System.out.println("Thread at obj1: "+Thread.currentThread().getName());
		}
		
	}

	public static void stageTwo() {
		synchronized (obj2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
			System.out.println("Thread at obj2: "+Thread.currentThread().getName());
		}
	}

	public static void process() {
		for (int i = 0; i < 3; i++) {
			stageOne();
			stageTwo();
		}
	}

	public static void main(String args[]) {
		System.out.println("Starting....");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				process();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				process();
			}
		});
		
		t1.start();
		t2.start();
		try {	
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start));
		System.out.println("List1: "+list1.size());
		System.out.println("List2: "+list2.size());
	}
}
