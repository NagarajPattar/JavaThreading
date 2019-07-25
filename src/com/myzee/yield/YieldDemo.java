package com.myzee.yield;

public class YieldDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object lock = new Object();
		// TODO Auto-generated method stub
		MyThread1 m1 = new MyThread1(lock);
		m1.start();
		MyThread2 m2 = new MyThread2(lock);
		m2.start();
		
//		synchronized(lock) {
		for (int i = 0; i < 10; i++) {
			System.out.println("main thread in control " + i);

			if(i == 1) {
				System.out.println("in main if");
				Thread.yield();
			}
		}
//		}
		
	}

}

class MyThread1 extends Thread {
	Object lock;
	public MyThread1(Object lock) {
		// TODO Auto-generated constructor stub
		this.lock = lock;
	}

	@Override
	public void run() {
//		synchronized(lock) {
		for (int i = 0; i < 10; i++) {
			System.out.println("child-------- 1 thread in controll " + i);
			if(i == 1) {
				System.out.println("in child 1 if");
				Thread.yield();
			}
		}
//		}
	}
}

class MyThread2 extends Thread {
	Object lock;
	public MyThread2(Object lock) {
		// TODO Auto-generated constructor stub
		this.lock = lock;
	}

	@Override
	public void run() {
//		synchronized(lock) {
		for (int i = 0; i < 10; i++) {
			System.out.println("child------------------- 2 thread in controll " + i);
			if(i == 1) {
				System.out.println("in child 2 if");
				Thread.yield();
			}
		}
//		}
	}
}

