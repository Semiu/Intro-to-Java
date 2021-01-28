/**
 * This is the implementation of multiple clients on multiple threads.
 * This avoids output stream blockage from multiple clients or speedy inputs from a client.
 * This works with the EchoForMCinMT class
 * The client side program is in the ClientSide folder
 */

package com.multiplethreadsnetwork;

import java.io.IOException;

import java.net.ServerSocket;


public class MultipleThreadServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(ServerSocket serverSocket = new ServerSocket(5000)){
			
			while(true) {
				
				new EchoForMCinMT(serverSocket.accept()).start();
				
				//A break-down implementation of the code in line 23 is 26 to 28
				//Socket socket = serverSocket.accept();
				//EchoForMCinMT echoForMCinMT = new EchoForMCinMT(socket);
				//echoForMCinMT.start();
				
			}
			
		}catch(IOException e) {
			System.out.println("Server exception " + e.getMessage());
			e.printStackTrace();
		}

	}

}
