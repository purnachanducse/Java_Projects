/**
 * 
 */
package com.threads;

/**
 * @author 10661300
 *
 */
class Runner1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class ImplementsRunnable {

	public static void main(String[] args) {
		Runner1 runner1 = new Runner1();
		Thread thread1 = new Thread(runner1);
		Thread thread2 = new Thread(runner1);

		thread1.start();
		thread2.start();
	}
}
