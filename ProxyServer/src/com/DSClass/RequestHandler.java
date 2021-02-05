package com.DSClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;

//
public class RequestHandler extends Thread {
	
	//Socket connected to client passed by Proxy server
	Socket clientSocket;

	InputStream inFromClient;

	OutputStream outToClient;
	
	byte[] request = new byte[1024];

	BufferedReader proxyToClientBufferedReader;

	BufferedWriter proxyToClientBufferedWriter;

	//changes here to the template provided---
	//ProxyServer proxyServer;

	//We only use the clientSocket, why passing the proxyServer as an argument
	//Maybe the proxyServer would be used to "Create a socket to connect to the web server (default port 80)"
	public RequestHandler(Socket clientSocket) {

		
		this.clientSocket = clientSocket;
		
		//this.proxyServer = proxyServer;

		try {
			clientSocket.setSoTimeout(2000);
			inFromClient = clientSocket.getInputStream();
			outToClient = clientSocket.getOutputStream();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	@Override
	public void run() {

		/**
			 * To do: Process the requests from a client. In particular
		*/
		
		/**
		 * (1) Check the request type, only process GET request and ignore others
		 */
		
		/**
		 * (2) If the url of GET request has been cached, respond with cached content
		 */
		
		/**
		 * (3) Otherwise, call method proxyServertoClient to process the GET request
		 */

	}

	
	private boolean proxyServertoClient(byte[] clientRequest) {

		FileOutputStream fileWriter = null;
		Socket serverSocket = null;
		InputStream inFromServer;
		OutputStream outToServer;
		
		// Create Buffered output stream to write to cached copy of file
		//We changed this from generateFileName() to generateRandomFileName() because that is the existing function
		String fileName = "cached/" + generateRandomFileName() + ".dat";
		
		// to handle binary content, byte is used
		byte[] serverReply = new byte[4096];
		
			
		/**
		 * To do
		 * (1) Create a socket to connect to the web server (default port 80)
		 * (2) Send client's request (clientRequest) to the web server, you may want to use flush() after writing.
		 * (3) Use a while loop to read all responses from web server and send back to client
		 * (4) Write the web server's response to a cache file, put the request URL and cache file name to the cache Map
		 * (5) close file, and sockets.
		*/
	
	}
	
	
	
	// Sends the cached content stored in the cache file to the client
	private void sendCachedInfoToClient(String fileName) {

		try {

			byte[] bytes = Files.readAllBytes(Paths.get(fileName));

			outToClient.write(bytes);
			outToClient.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			if (clientSocket != null) {
				clientSocket.close();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	// Generates a random file name  
	public String generateRandomFileName() {

		String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
		SecureRandom RANDOM = new SecureRandom();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10; ++i) {
			sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return sb.toString();
	}
	
	
	
}
