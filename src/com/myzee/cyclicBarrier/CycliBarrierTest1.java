package com.myzee.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


class Task implements Runnable {
	CyclicBarrier barrier;
	public Task(CyclicBarrier barrier) {
		this.barrier = barrier;	
	}
	
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " has arrived");
		try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " has finished");
		
	}
}


public class CycliBarrierTest1 {
	public static CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
		public void run () {
			System.out.println("All parties have been arrived, lets play");
		}
	});
	public static void main (String arg[]) {
		Thread t1 = new Thread(new Task(barrier));
		Thread t2 = new Thread(new Task(barrier));
		Thread t3 = new Thread(new Task(barrier));
		
		t1.start();
		t2.start();
		t3.start();
	}
}
