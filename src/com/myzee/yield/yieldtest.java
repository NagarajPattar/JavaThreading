package com.myzee.yield;

public class yieldtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread m1 = new MyThread();
		m1.start();
		
		for (int i = 0; i < 10; i++) {
			
			Thread.yield();
			System.out.println("main thread in control");
		}
		
	}

}

class MyThread extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("child thread in controll" + i);
		}
	}
}