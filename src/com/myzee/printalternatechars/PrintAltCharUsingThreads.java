package com.myzee.printalternatechars;

public class PrintAltCharUsingThreads {

	public static void main(String[] args) {
		CharacterInit i = new CharacterInit('a', true);
		FirstChar f = new FirstChar(i);
		NextChar n = new NextChar(i);
		f.start();
		n.start();
	}

}

class FirstChar extends Thread {
	CharacterInit i;
	public FirstChar(CharacterInit i) {
		this.i= i;
	}

	public void run() {
		synchronized(i) {
		while(true) {
			if(i.start == true) {
				System.out.println(Thread.currentThread().getName() + " - " + (char)(i.i++));
				i.start = false;
				try {
					i.wait();
					i.notify();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					i.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
	}
}

class NextChar extends Thread {
	CharacterInit i;
	public NextChar(CharacterInit i) {
		this.i= i;
	}
	
	public void run() {
		synchronized (i) {
			while(true) {
				if(i.start == false) {
					System.out.println(Thread.currentThread().getName() + " - " + (char)(i.i++));
					i.start = true;
					i.notify();
					try {
						i.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}

class CharacterInit {
	int i;
	boolean start;
	public CharacterInit(int i, boolean start) {
		this.i = i;
		this.start = start;
	}
}
