package com.myzee.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTestUsingResource {
	static int i = 0;
	static Semaphore sem = new Semaphore(4);
	static Resource res = new Resource(i);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new MyThread(), "A");
		Thread t2 = new Thread(new MyThread(), "B");
		Thread t3 = new Thread(new MyThread(), "C");
		Thread t4 = new Thread(new MyThread(), "D");
		Thread t5 = new Thread(new MyThread(), "E");
		Thread t6 = new Thread(new MyThread(), "F");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
	}
	static class MyThread implements Runnable {
		public void run () {
			try {
				sem.acquire();
				res.compute();
//				System.out.println("Aquiring lock on resource");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				sem.release();
				System.out.println("Releasing of lock by " + Thread.currentThread().getName());
			}
		}
	}
}

class Resource {
	int i;
	public Resource(int i) {
		// TODO Auto-generated constructor stub
		this.i = i;
	}
	
	protected void compute() {
		System.out.println("Computing " + i++ + " by " + Thread.currentThread().getName());
	}
}