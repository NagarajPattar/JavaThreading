package com.myzee.threads;

public class UsingRunnable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyRunnable myr = new MyRunnable();
		Thread t = new Thread(myr);
		t.start();
		int i = 0;
		while(i++ < 10) {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println(Thread.currentThread().getName() + " ends");

	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " thread ends");
	}	
}
