/**
 * 
 */
package com.threads.deadlock;

/**
 * @author 10661300
 *
 */
public class DeadlockTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner runner = new Runner();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				runner.firstThread();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				runner.secondThread();
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

		runner.finished();
	}

}
