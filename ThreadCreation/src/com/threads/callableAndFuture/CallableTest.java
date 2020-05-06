/**
 * 
 */
package com.threads.callableAndFuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 10661300
 *
 */
public class CallableTest {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService service = Executors.newCachedThreadPool();
		Future<Integer> future = service.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);
				System.out.println("Starting...");
				Thread.sleep(duration);
				System.out.println("Finished...");
				return duration;
			}
		});

		service.shutdown();
		System.out.println("Result is: " + future.get());
	}
}
