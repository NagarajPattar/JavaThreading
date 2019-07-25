/*
 * not tested properly
 */

package com.myzee.timertask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TimerTaskDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimerTaskThread tt = new TimerTaskThread();
		Timer tm = new Timer(true);
		tm.schedule(tt, 10000);
		Thread t = new Thread(tt);
		t.start();
	}

}


class TimerTaskThread extends TimerTask {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " - started");
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " - ended");
	}
	
}
