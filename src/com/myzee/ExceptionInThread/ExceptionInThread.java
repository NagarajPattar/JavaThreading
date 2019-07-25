package com.myzee.ExceptionInThread;

public class ExceptionInThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable mr = new MyRunnable();
		Thread t = new Thread(mr);
		t.start();
	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=5; i >= 0; i--) {
			
			try {
				System.out.println("divide");
				System.out.println("10/" + i + " - " + (10/i));
				System.out.println("done");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("handle thread exception");
			}
		}
		System.out.println("statements after exception occured");
	}
	
}
