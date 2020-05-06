/**
 * 
 */
package com.threads.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author 10661300
 *
 */
public class Connection {

	private static Connection instance = new Connection();

	private Semaphore semaphore = new Semaphore(10, true);

	private int connections = 0;

	private Connection() {

	}

	public static Connection getInstance() {
		return instance;
	}

	public void connect() throws InterruptedException {

		semaphore.acquire();

		try {
			doConnect();
		} finally {
			semaphore.release();
		}
	}

	public void doConnect() {
		synchronized (this) {
			connections++;
			System.out.println(
					"Current connectoins: " + connections + "Current Thread is: " + Thread.currentThread().getName());
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (this) {
			connections--;
		}
	}
}
