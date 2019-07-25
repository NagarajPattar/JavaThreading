package com.myzee.semaphore;
import java.util.concurrent.Semaphore;


public class SemaphoreTest_UsingRunnable {

	static Semaphore sem = new Semaphore(1);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread m1 = new Thread (new MyThread(), "a");
		Thread m2 = new Thread (new MyThread(), "b");
		Thread m3 = new Thread (new MyThread(), "c");
		Thread m4 = new Thread (new MyThread(), "d");
		Thread m5 = new Thread (new MyThread(), "e");
		Thread m6 = new Thread (new MyThread(), "f");
		
		m1.start();
		m2.start();
		m3.start();
		m4.start();
		m5.start();
		m6.start();
	}

	static class MyThread implements Runnable {
		public void run() {
			try {
				sem.acquire();
				System.out.println(Thread.currentThread().getName() + " aquiring lock");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				System.out.println(Thread.currentThread().getName() + " releasing lock");
				sem.release();
			}
		}
	}
	
}
