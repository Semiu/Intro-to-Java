package com.interruptthread;

import com.threads.MyRunnable;
import com.threads.OneThread;

public class MainThread {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println("Hello from the main thread!");
		
		//Object of the OneThread class
		Thread oneThread = new OneThread();
		
	//Invocking the start method of the Thread class on the Thread subclass to start the thread
		oneThread.start();
		
		new Thread () {
			public void run() {
				System.out.println("Hello from the anonymous thread!");
			}
		}.start();
		
		Thread myRunnable = new Thread(new MyRunnable() {
			@Override
			public void run() {
				//super.run();
				System.out.println("A thread from anonymous run");
			}
		});
		
		myRunnable.start();
		
		System.out.println("Hello again from the main thread!");
		
		//oneThread.start(); Running this would create an IllegalThreadException because one thread is allowed
	}

}
