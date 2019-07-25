package com.myzee.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


class TaskThread implements Runnable {
	CyclicBarrier barrier;
	public TaskThread(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName() + " has started");
		try {
			barrier.await();
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " has finished");
	}
}

public class CycliBarrierTest2 {
	static CyclicBarrier barrier = new CyclicBarrier(3, new Runnable(){
		public void run() {
			System.out.println("all threads have been started, lets move");
		}
		
	});
	public static void main(String arg[]) {
		Thread t1 = new Thread(new TaskThread(barrier));
		Thread t2= new Thread(new TaskThread(barrier));
		Thread t3 = new Thread(new TaskThread(barrier));
		
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
