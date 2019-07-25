package com.myzee.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(5);
		int i = 1;
		while (i <= 10) {
			executor.execute(new WorkerThread());
			i++;
		}
		executor.shutdown();
		System.out.println("All threads finished");
		
	}

}

class WorkerThread implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started");
		processCommand();
		System.out.println(Thread.currentThread().getName() + " end");
	}

	private void processCommand() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}