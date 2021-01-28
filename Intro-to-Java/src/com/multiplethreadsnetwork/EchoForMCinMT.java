/**
 * EchoForMCinMT is a subclass of the Java Thread to work for the implementation of multiple clients (MC) in multiple threads (MT)
 * It works with the MultipleThreadServer class 
 */
package com.multiplethreadsnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoForMCinMT extends Thread {
	//class object
	private Socket socket;
	//Constructor
	public EchoForMCinMT (Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader input = new BufferedReader (new InputStreamReader(socket.getInputStream()));
			
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
			while(true) {
				String echoString = input.readLine();
				System.out.println("Client's input received! " + echoString);
				if(echoString.equals("exit")) {
					break;
				}
				try {
					
					Thread.sleep(15000);
					
				}catch(InterruptedException e) {
					System.out.println("Thread Interrupted!");
					
				}
				
				output.println(echoString);
			
			}
			
		}catch(IOException e) {
			System.out.println("Oops: " + e.getMessage());
		} finally {
			try {
				socket.close();
			}catch(IOException e) {
				//yeah! Shit happens!
			}
		}
	}
	
}
