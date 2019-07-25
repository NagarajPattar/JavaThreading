package com.myzee.waitAndNotify;

public class WaiterAndNotifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

class Message {
	private boolean flag = false;
	public Message(boolean flag) {
		this.flag = flag;
	}
	
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}

class Waiter implements Runnable {
	Message msg;
	public Waiter(Message msg) {
		this.msg = msg;
	}
	
	@Override
	public void run() {
		synchronized(msg) {
			if(msg.getFlag() == false) {
				try {
					System.out.println("waiter is waiting");
					Thread.sleep(100);
					msg.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}

class Notifier implements Runnable {
	Message msg;
	public Notifier(Message msg) {
		this.msg = msg;
	}
	
	@Override
	public void run() {
		synchronized(msg) {
			System.out.println("notifier notifying the call");
			msg.setFlag(true);
			msg.notify();
			System.out.println("after notifying the waiting thread");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Notifier ends");
		}
	}
	
}
