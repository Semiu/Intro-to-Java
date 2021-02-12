package com.DSClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
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

	ProxyServer proxyServer;

	//We only use the clientSocket, why passing the proxyServer as an argument
	//Maybe the proxyServer would be used to "Create a socket to connect to the web server (default port 80)"
	//public RequestHandler(Socket clientSocket, ProxyServer proxyServer) {
	//localhost, port number
	public RequestHandler(Socket clientSocket) {

		
		this.clientSocket = clientSocket;
		
		//this.proxyServer = proxyServer;

		try {
			clientSocket.setSoTimeout(2000);

			inFromClient = clientSocket.getInputStream();
			outToClient = clientSocket.getOutputStream();
			
			//proxyToClientBufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			//proxyToClientBufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	@Override
	public void run() {

		/**
		 * To do: Process the requests from a client. In particular
		*/
		
		//String requestStringReader;
		String requestStringSocket;
		byte [] clientRequest = null;
		String fileName = null;
		
		try {
		
			//requestStringReader = proxyToClientBufferedReader.readLine();
			requestStringSocket = inFromClient.toString();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error reading request from client");
			return;
		}
		
		// Get the Request type
		//String requestFromReader = requestStringReader.substring(0,requestStringReader.indexOf(' '));
		
		/**
		 * (1) Check the request type, only process GET request and ignore others
		 * (3) Otherwise, call method proxyServertoClient to process the GET request when the request Method id GET
		 * and 
		 */
		try {
		
		URL url = new URL(requestStringSocket);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		String requestMethod= conn.getRequestMethod();
		
		if(requestMethod.equals("GET") ) {
			
			if(Paths.get(fileName) != null) {
				/** (2) If the url of GET request has been cached, respond with cached content
				 * Another option to try here is to write a getCachedPage () for ProxyServer, taking url as an argument.
				 * Then, check in the if bracket, instead of the Paths.get(fileName)
				 * I stick to this pending testing to be consistent with the sendCachedInfoToClient(fileName) provided
				 * in the template.    
				*/
				sendCachedInfoToClient(fileName);
			}
			else {
				//handleRequest(requestStringSocket); - A function of this signature will be written if need be.
				proxyServertoClient(clientRequest);
			}
			
		} else {
			/**only process GET request and ignore others*/
			System.out.println("Only GET method is processed!");
			
		}
			
		}catch(Exception e) {
			System.out.println("URL is incorrect!");
			
		}

	}
	
	//private boolean proxyServertoClient(byte[] clientRequest) {
	/**
	 * The return type of proxyServertoClient is changed to void because that is what makes sense for a method that would 
	 * be invoked for action different from checking. This is suggested by the instruction that this method would be called
	 * when the HTTP request is 'GET'.
	 * We changed this from generateFileName() to generateRandomFileName() because that is the existing function
	 * @param clientRequest
	 */
	private void proxyServertoClient(byte[] clientRequest) {

		FileOutputStream fileWriter = null;
		//Socket serverSocket = null;
		//InputStream inFromServer = null;
		//OutputStream outToServer = null;
		
		//
		String clientURL = clientRequest.toString();
		
		// Create Buffered output stream to write to cached copy of file
		String fileName = "cached/" + generateRandomFileName() + ".dat";
		
		// to handle binary content, byte is used
		byte[] serverReply = new byte[4096];
		
		/**
		 * To do:
		*/
		try {
			/*
			 * (1) Create a socket to connect to the web server (default port 80)
			 */
			
			// Get actual IP associated with this URL through DNS
			InetAddress address = InetAddress.getByName(clientURL);
			
			//Port set at 80
			Socket proxyToServerSocket = new Socket(address, 80);
			proxyToServerSocket.setSoTimeout(5000);
			
			/*
			 * (2) Send client's request (clientRequest) to the web server, you may want to use flush() after writing.
			 */
	
			// Client and Remote will both start sending data to proxy at this point
			// Proxy needs to asynchronously read data from each party and send it to the other party
			//Create a Buffered Writer between proxy and remote
			BufferedWriter proxyToServerBufferWriter = new BufferedWriter(new OutputStreamWriter(proxyToServerSocket.getOutputStream()));
			proxyToServerBufferWriter.write(clientRequest.toString());
			proxyToServerBufferWriter.flush();
			
			// Create Buffered Reader from proxy and remote
			BufferedReader proxyToServerBufferReader = new BufferedReader(new InputStreamReader(proxyToServerSocket.getInputStream()));
			
			/*
			 * (3) Use a while loop to read all responses from web server and send back to client
			 */
			try {
				
				int read;
				
				do {
					read = proxyToServerSocket.getInputStream().read(serverReply);
					/*
					 * (4) Write the web server's response to a cache file, put the request URL and cache file name to the cache Map
					 */
					//ProxyServer.putCache(serverReply.toString(), fileName);
					
					if (read > 0) {
						clientSocket.getOutputStream().write(serverReply, 0, read);
						
						if (proxyToServerSocket.getInputStream().available() < 1) {
							clientSocket.getOutputStream().flush();
						}
					
				
					}
				} while (read>=0);
				
			}catch(Exception e) {
				
			}
			/*
			 * (5) close file, and sockets.
			 */

			if(proxyToServerSocket != null){
				proxyToServerSocket.close();
			}
			
			if(proxyToClientBufferedWriter != null){
				proxyToClientBufferedWriter.close();
			}
			
			if(proxyToServerBufferWriter != null){
				proxyToServerBufferWriter.close();
			}
			
			if(proxyToServerBufferReader != null){
				proxyToServerBufferReader.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
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
