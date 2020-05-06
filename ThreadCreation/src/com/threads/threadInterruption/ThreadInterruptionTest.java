/**
 * 
 */
package com.threads.threadInterruption;

import java.util.Random;

/**
 * @author 10661300
 *
 */
public class ThreadInterruptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable() {

			@SuppressWarnings("static-access")
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Random random = new Random();
				for (int i = 0; i < 1E8; i++) {
//					if(Thread.currentThread().interrupted()) {
//						System.out.println("Interrupted");
//					}

					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						System.out.println("Interrupted: " + e.getMessage());
					}
					Math.sin(random.nextDouble());
				}
			}
		});

		t1.start();

		t1.interrupt();

		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
