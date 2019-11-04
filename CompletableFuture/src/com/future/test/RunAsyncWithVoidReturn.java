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
public class RunAsyncWithVoidReturn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
//		try {
//			String result = completableFuture.get();
//			completableFuture.complete("Future's resut");
//			System.out.println("Result : "+result);
//		} catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//Running Async task in the background and don't want to return anything
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(
				new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("I will run in seperate thread rather than in main thred");
					}
				}
				
				);
		
		try {
			System.out.println("Get method: "+completableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
