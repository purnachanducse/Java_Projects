/**
 * 
 */
package com.future.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * @author Sapparapu
 *
 */
public class SupplyAsyncWithReturn {
   public static void main(String[] args) throws InterruptedException, ExecutionException {
	   CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {

				@Override
				public String get() {
					return "Result of Async computation";
				}
	   	});
	   
	   String result = future.get();
	   System.out.println("Print: "+result);
   }
}
