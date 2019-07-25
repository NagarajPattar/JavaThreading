package com.myzee.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		int i = 10;
		while(i > 0) {
			executorService.submit(new MyThreadForPool());
			i--;
		}
		executorService.shutdown();
		if(executorService.isShutdown())
			System.out.println("All thread finished the job");
	}

}

class MyThreadForPool extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " finished");
		
	}
}

//9343673366

//09972411154
