/**
 * This is the implementation of multiple clients on a SingleThreadServer class to accept multiple connections.
 * The client side program is in the ClientSide folder
 */

package com.multiplethreadsnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultipleClientThreadServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(ServerSocket serverSocket = new ServerSocket(5000)){
			
			//Lines 24 to 31 taken from here in the single client -single thread implementation
			while(true) {
				// Socket to connect with the client(s) who will be on the same port but different sockets
				Socket socket = serverSocket.accept();
				System.out.println("Client connected!");
				
				//Input streams for the server
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//Output streams for the server
				PrintWriter output = new PrintWriter(socket.getOutputStream(), true); //set true to flush the output stream automatically
				
				//Continously takes input from the client
				String echoString = input.readLine();
				
				//Putting the server to momentary sleep after very input so that its output is delivered to avoid blockage
				try {
					Thread.sleep(15000);
				}catch(InterruptedException e) {
					System.out.println("Thread interrupted");				
				}
				
				if(echoString.equals("exit")) {
					//if the input is "exit"
					break;
				}
				output.println("Echo from multithreaded server: " + echoString);
			}
			
		}catch(IOException e) {
			System.out.println("Server exception " + e.getMessage());
			e.printStackTrace();
		}

	}

}
