package com.interruptthread;

public class OneThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("A thread from " + currentThread().getName());
	}

}
