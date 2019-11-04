/**
 * 
 */
package com.future.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Sapparapu
 *
 */
public class RunAsyncWithReturnWithLambda {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(
				() -> {
						try {
							TimeUnit.SECONDS.sleep(1);
							System.out.println("In Child thread");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				);
		
		System.out.println("Get method: "+future.get());
	}
	
}
