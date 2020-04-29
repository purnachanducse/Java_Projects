/**
 * 
 */
package com.threads;

import java.util.Scanner;

/**
 * @author 10661300
 *
 */

class Processor extends Thread {

	private volatile boolean running = true;

	@Override
	public void run() {
		while (running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutDown() {
		running = false;
	}

}

public class VolatileKeyword {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Processor p1 = new Processor();
		p1.start();

		System.out.println("Press return to stop");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

	}

}
