/**
 *This represents the server side of the single thread client - server communication
 *The client side programs are in the ClientSide folder
 * @author Semiu
 *
 */
package com.singlethreadserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(ServerSocket serverSocket = new ServerSocket(5000)){
			// Socket to connect with the client(s) who will be on the same port but different sockets
			Socket socket = serverSocket.accept();
			System.out.println("Client connected!");
			
			//Input streams for the server
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//Output streams for the server
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true); //set true to flush the output stream automatically
			
			while(true) {
				//Continously takes input from the client
				String echoString = input.readLine();
				if(echoString.equals("exit")) {
					//if the input is "exit"
					break;
				}
				output.println("Echo from server: " + echoString);
			}
		}catch(IOException e) {
			System.out.println("Server exception " + e.getMessage());
			e.printStackTrace();
		}

	}

}
