/**
 * 
 */
package com.threads.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 10661300
 *
 */
public class SemaphoreTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 2000; i++) {
			service.submit(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Connection.getInstance().connect();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		service.shutdown();
		service.awaitTermination(1, TimeUnit.DAYS);
	}
}
