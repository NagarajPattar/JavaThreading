package com.myzee.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTester implements Runnable{
	public static CyclicBarrier barrier = new CyclicBarrier(3);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrierTester tester = new CyclicBarrierTester();
		Thread tMain = new Thread(tester);
		tMain.start();
	}
	
	public void run() {
		System.out.println("number of parties required to trip the barrier - " + CyclicBarrierTester.barrier.getParties());
		System.out.println("value1 and value2 are - " + taskThread1.value1 + " , " + taskThread2.value2);
		
		taskThread1 task1 = new taskThread1();
		Thread t1 = new Thread (task1);
		
		Thread t2 = new Thread(new taskThread2());
		
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.out.println(Thread.currentThread().getName() + " has started");
			barrier.await();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " has finished");
		System.out.println("after barrier test -  value1, value2 and (value1 + value2) are - " + taskThread1.value1 + ", " + taskThread2.value2  + ", and " + (taskThread1.value1 + taskThread2.value2));
		barrier.reset();
		System.out.println("barrier reset successful");
		
	}

}

class taskThread1 implements Runnable {
	public static int value1;
	public void run() {
		value1 = 2 * 4;
		try {
			System.out.println(Thread.currentThread().getName() + " has started");
			CyclicBarrierTester.barrier.await();
			System.out.println(Thread.currentThread().getName() + " has finished");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class taskThread2 implements Runnable {
	public static int value2;
	public void run() {
		value2 = 4 * 4;
		try {
			System.out.println(Thread.currentThread().getName() + " has started");
			CyclicBarrierTester.barrier.await();
			System.out.println(Thread.currentThread().getName() + " has finished");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}