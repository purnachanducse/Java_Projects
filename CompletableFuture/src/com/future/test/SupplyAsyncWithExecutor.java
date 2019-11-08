/**
 * 
 */
package com.future.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author Sapparapu
 *
 */
public class SupplyAsyncWithExecutor {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Executor executor = Executors.newFixedThreadPool(10);
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			return "Thread Method";
		}, executor);
		
		System.out.println("Future: "+future.get());
	}
}
