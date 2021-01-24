package com.interruptthread;

public class OneThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("A thread from " + currentThread().getName());
		
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			System.out.println("Another thread after sleep");
			return;
		}
		
		 System.out.println("I am awake after three seconds");
	}

}
