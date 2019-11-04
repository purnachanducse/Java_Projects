package com.threads.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MainClassThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object> listOfObjs = new ArrayList();
		listOfObjs.add(new Thread_A());
		listOfObjs.add(new Thread_B());
		List<CompletableFuture<List<String>>> all= listOfObjs.stream().map(obj -> getLit(obj)).collect(Collectors.toList());
		CompletableFuture<Void> allFutures = CompletableFuture.allOf(
				all.toArray(new CompletableFuture[all.size()])
				);
		
		CompletableFuture<List<List<String>>> allPageContentsFuture = allFutures.thenApply(v -> {
			return all.stream().map(data -> data.join()).collect(Collectors.toList());
		});

		try {
			System.out.println(allPageContentsFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static CompletableFuture<List<String>> getLit(Object obj){
		
			return CompletableFuture.supplyAsync(() ->{
				List<String> res = new ArrayList<>(); 
				if(obj instanceof Thread_A) {
					Thread_A a =(Thread_A)obj;
					res = a.getListOfA();
				}else if(obj instanceof Thread_B) {
					Thread_B a =(Thread_B)obj;
					res = a.getListOfB();
				}
				return res;
			});
			
	}//end-of-static-method

}//end-of-class
