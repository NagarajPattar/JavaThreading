package com.myzee.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsingCallableToReturn {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//Get ExecutorService from Executors utility class, thread pool size is 10
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		//Create MyCallable instance
		MyCallable callTask = new MyCallable();		
		
		//create a list to hold the Future object associated with Callable
		List<Future<String>> futList = new ArrayList<>();
		
		for(int i = 0; i < 100; i++) {			
			//submit Callable tasks to be executed by thread pool
			Future<String> fut =  executor.submit(callTask);
			
			//add Future to the list, we can get return value using Future
			futList.add(fut);
		
			/*if(i%10 == 0) {
				Thread.sleep(1000);
			}*/
		}

		for(int i = 0; i < futList.size(); i++) {
			System.out.println(futList.get(i).get());
		}
		executor.shutdown();
	}

}

class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		//return the thread name executing this callable task
		return Thread.currentThread().getName();
	}
}
