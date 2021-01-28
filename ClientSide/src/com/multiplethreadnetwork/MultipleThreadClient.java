/**
 * The client side of the client-server communication implementation
 * It works for the multiple thread server
 * @author Semiu
 *
 */

package com.multiplethreadnetwork;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class MultipleThreadClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Socket socket = new Socket("localhost", 5000)){
			//Setting time (5 secs) out for the client socket connection
			//Note: This is very small, just to demonstrate time out
			socket.setSoTimeout(5000);
			
			//Input stream for the client
			BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//Output stream from the client
			PrintWriter stringtoEcho = new PrintWriter(socket.getOutputStream(), true);
			
			//Scanner class to take input from console
			Scanner scanner = new Scanner(System.in);
			String echoString;
			String response;
			
			do {
				System.out.println("Enter the string to be echoed: ");
				echoString = scanner.nextLine();
				
				//Output
				stringtoEcho.println(echoString);
				
				//Input
				if(!echoString.equals("exit")) {
					response = echoes.readLine();
					System.out.println(response);
				}
				
			}while(!echoString.equals("exit"));
			
			scanner.close();
			
		}catch(SocketTimeoutException e){
			System.out.println("The socket timed out");
			
			
		}catch(IOException e) {
			System.out.println("Client error: " + e.getMessage());
			
		}
	}
}
