/**
 * This package, by the implementation of the classes therein, illustrates how Java runs its threads and
 * behave when the interrupt function is used.
 * A waiting thread can also be joined 
 * 
 */

package com.interruptthread;

public class MainThread {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println("Hello from the main thread!");
		
		//Object of the OneThread class
		Thread oneThread = new OneThread();
		oneThread.setName("==One Thread==");
		oneThread.start();
		
	
		new Thread () {
			public void run() {
				System.out.println("Hello from the anonymous thread!");
			}
		}.start();

		
		Thread myRunnable = new Thread(new MyRunnable() {
			@Override
			public void run() {
				
				System.out.println("A thread from anonymous run");
				
				//The try and catch blocs for joining threads
				try {
					oneThread.join();
					System.out.println("I am running because a thread was terminated");
				} catch(InterruptedException e) {
					System.out.println("I could not wait since I was interrupted");
				}
				
			}
		});
		
		myRunnable.start();
		
		//oneThread.interrupt(); //This should be commented out so that the InterruptedException e in OneThread 
		//class will not be thrown. When left uncommented, the try and catch in the above myRunnable must be commented out.
		
		System.out.println("Hello again from the main thread!");
	
	}

}
