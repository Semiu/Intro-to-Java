/**
 * The client side of the client-server communication implementation
 * It works for both the single and multiple thread server
 * @author Semiu
 *
 */
package com.singlethreadnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Socket socket = new Socket("localhost", 5000)){
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
			
		}catch(IOException e) {
			System.out.println("Client error: " + e.getMessage());
			
		}
	}
}
