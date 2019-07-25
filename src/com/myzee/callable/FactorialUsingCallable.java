/*
 * Write a Callable<T> task to find factorial of a number.
 * submit that task to ExecutorService.
 * ExecutorService will find a thread to execute the task
 * returns the result in Future<T> object.
 */
package com.myzee.callable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FactorialUsingCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//create tasks
		FactorialService f5 = new FactorialService(5);
		FactorialService f6 = new FactorialService(6);
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Long> fr5 = executor.submit(f5);
		System.out.println("Factorial of 10 is - " + fr5.get());
		
		Future<Long> fr6 = executor.submit(f6);
		System.out.println("Factorial of 20 is - " + fr6.get());
		
	}

}

class FactorialService implements Callable<Long>{
	
	int num;
	public FactorialService(int num) {
		this.num = num;
	}

	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		return findFactorial(this.num);
	}

	private Long findFactorial(int num) throws InterruptedException {
		// TODO Auto-generated method stub
		Long result = new Long(1);
		while(num != 0) {
			result = result * num;
			num--;
			Thread.sleep(1000);
		}
		
		HashSet<Integer> h = new HashSet<>();
		h.add(null);
		h.add(null);
		h.add(null);
		h.add(5);
		h.add(3);
		Iterator<Integer> it = h.iterator();
		while (it.hasNext()) {
			Integer i = (Integer) it.next();
			System.out.println(i);
		}
		
		return result;
	}
	
}
