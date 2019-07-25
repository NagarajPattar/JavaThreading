package com.myzee.semaphore;
import java.util.concurrent.Semaphore;


public class SemaphoreTest_UsingExendThread {

	static Semaphore sem = new Semaphore(4);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread m1 = new MyThread ("a");
		MyThread m2 = new MyThread ("b");
		MyThread m3 = new MyThread ("c");
		MyThread m4 = new MyThread ("d");
		MyThread m5 = new MyThread ("e");
		MyThread m6 = new MyThread ("f");
		
		m1.start();
		m2.start();
		m3.start();
		m4.start();
		m5.start();
		m6.start();
	}

	static class MyThread extends Thread {
		String name;
		public MyThread(String name) {
			this.name = name;
		}
		public void run() {
			try {
				sem.acquire();
				System.out.println(Thread.currentThread().getName() + " aquiring lock");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				System.out.println(Thread.currentThread().getName() + " releasing lock");
				sem.release();
			}
		}
	}
	
}
