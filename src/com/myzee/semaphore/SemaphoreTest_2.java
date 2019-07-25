package com.myzee.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Semaphore sem = new Semaphore(4);
		MyThread t1 = new MyThread(sem);
		MyThread t2 = new MyThread(sem);
		MyThread t3 = new MyThread(sem);
		MyThread t4 = new MyThread(sem);
		MyThread t5 = new MyThread(sem);
		MyThread t6 = new MyThread(sem);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();		
		
	}

}

class MyThread extends Thread {
	Semaphore sem;
	MyThread(Semaphore sem) {
		this.sem = sem;
	}
	
	public void run() {
		try {
			sem.acquire();
			System.out.println(Thread.currentThread().getName() + " aquiring lock");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + " releasing lock");
			sem.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
