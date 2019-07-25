package com.myzee.threads;

public class UsingThreadClass {

	public static void main(String[] args) throws InterruptedException {
		MyThread t = new MyThread();
		t.start();
		for(int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println("main thread - ends");
	}

}

class MyThread extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println(Thread.currentThread().getName() + " - ends");
	}
}
