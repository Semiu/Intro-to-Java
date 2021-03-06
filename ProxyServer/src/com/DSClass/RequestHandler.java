package com.DSClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;

//
public class RequestHandler extends Thread {
	
	//Socket connected to client passed by Proxy server
	Socket clientSocket;

	InputStream inFromClient;

	OutputStream outToClient;
	
	//byte[] request = new byte[1024];

	BufferedReader proxyToClientBufferedReader;

	BufferedWriter proxyToClientBufferedWriter;

	ProxyServer proxyServer;

	//We only use the clientSocket, why passing the proxyServer as an argument
	//Also, the object instance of RequestHandler.java to start a thread takes only clientSocket as argument
	
	public RequestHandler(Socket clientSocket) {

		
		this.clientSocket = clientSocket;

		try {
			clientSocket.setSoTimeout(2000);
	
			proxyToClientBufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	@Override
	public void run() {

		/**
		 * To do: Process the requests from a client. In particular
		*/
		String requestStringReader;
		String fileName = null;
		
		try {
		
			requestStringReader = proxyToClientBufferedReader.readLine();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error reading request from client");
			return;
		}
		
		// Parsing requestStringReader
		
		//Getting the request type
		String request = requestStringReader.substring(0,requestStringReader.indexOf(' '));

		//remove request type and space
		String urlString = requestStringReader.substring(requestStringReader.indexOf(' ')+1);

		// Remove everything past next space
		urlString = urlString.substring(0, urlString.indexOf(' '));

		// Prepend http:// if necessary to create correct URL
		if(!urlString.substring(0,4).equals("http")){
			String temp = "http://";
			urlString = temp + urlString;
			}

		// Get the Request type
		/**
		* (1) Check the request type, only process GET request and ignore others
		* (3) Otherwise, call method proxyServertoClient to process the GET request when the request Method id GET
		* and 
		*/
		
		try {
			
			//To show the list of established connection with the machine
			if (request.equals("CONNECT")) {System.out.println(urlString + " is an established connection from this machine");}
			
			//Process the GET method
			if (request.equals("GET")) {
				
				//Call the method for processing the GET method
				proxyServertoClient(urlString);
			 
			}else {
				/**only process GET request and ignore others*/
				System.out.println("Only GET method is processed!");
			}
			if(Paths.get(fileName) != null) {
				/** (2) If the url of GET request has been cached, respond with cached content
				 * Another option to try here is to write a getCachedPage () for ProxyServer, taking url as an argument.
				 * Then, check in the if bracket, instead of the Paths.get(fileName)
				 * I stick to this pending testing to be consistent with the sendCachedInfoToClient(fileName) provided
				 * in the template.    
				*/
			sendCachedInfoToClient(fileName);
			}
		
		}catch(Exception e) {
			System.out.println(urlString + " is a bad URL!");
			
		}

	}
	//End of run method
	
	
	
	//private boolean proxyServertoClient(byte[] clientRequest) {
	/**
	 * The return type of proxyServertoClient is changed to void because that is what makes sense for a method that would 
	 * be invoked for action different from checking. This is suggested by the instruction that this method would be called
	 * when the HTTP request is 'GET'.
	 * We changed this from generateFileName() to generateRandomFileName() because that is the existing function
	 * @param clientRequest
	 * Since proxyServertoClient method is what is expected to be called to process the GET request, it only makes sense it
	 * takes the urlString as the argument 
	 */
	//private void proxyServertoClient(byte[] clientRequest) {
	
	//http://www.columbia.edu/~fdc/sample.html 
	private void proxyServertoClient(String urlString) {
		
		// Create File output stream to write to cached copy of file
		String fileName = "cached/" + generateRandomFileName() + ".txt";
		
		// to handle binary content, byte is used
				
		StringBuffer serverResponse = new StringBuffer();
		
		/**
		 * To do:
		*/
		URL fullURL;				
		try {
			/*
			 * (1) Create a socket to connect to the web server (default port 80)(port extracted as the option, for testing)
			 */
			fullURL = new URL (urlString);
			String domainURL = fullURL.getHost();
			
			// Get actual IP associated with this URL through DNS
			InetAddress address = InetAddress.getByName(domainURL);
			
			//Port set at 80 
			Socket proxyToServerSocket = new Socket(address, 80);
			proxyToServerSocket.setSoTimeout(5000);
			
			/*
			 * (2) Send client's request (clientRequest) to the web server HttpURLConnection
			 */
			// Create the URL
			URL remoteURL = new URL(urlString);
			// Create a connection to remote server
			HttpURLConnection proxyToServerCon = (HttpURLConnection)remoteURL.openConnection();
			
			proxyToServerCon.setRequestProperty("User-Agent", "Mozilla/5.0");  
			
			int responseCode = proxyToServerCon.getResponseCode();
			
			System.out.println("The response code is " + responseCode);
			
			// Client and Remote will both start sending data to proxy at this point
			// Proxy needs to asynchronously read data from each party and send it to the other party
			//Create a Buffered Writer between proxy and remote
			
			if (responseCode == 200) {
				BufferedReader toClient = 	new BufferedReader(new InputStreamReader(proxyToServerCon.getInputStream()));
				
				String inputLine;
				
				while ((inputLine = toClient.readLine()) != null) {
					
					serverResponse.append(inputLine.getBytes());
					
					outToClient.write(inputLine.getBytes(StandardCharsets.UTF_8));
					
	
					outToClient.flush();
					
				}
				
				toClient.close();
			}
			// Create Buffered Reader from proxy and remote
			BufferedReader proxyToServerBufferReader = new BufferedReader(new InputStreamReader(proxyToServerSocket.getInputStream()));
						
			BufferedWriter proxyToServerBufferWriter = new BufferedWriter(new OutputStreamWriter(proxyToServerSocket.getOutputStream()));
			
			//
			FileOutputStream	fileWriter = new FileOutputStream(fileName);
			
			fileWriter.close();
			
			/*
			 * (3) Use a while loop to read all responses from web server and send back to client
			 */
			try {
				
				int read;
				
				do {
				
					read =  proxyToServerSocket.getInputStream().read();
					/*
					 * (4) Write the web server's response to a cache file, put the request URL and cache file name to the cache Map
					 */
					ProxyServer.putCache(serverResponse.toString(), fileName);
					
					if (read > 0) {
						clientSocket.getOutputStream().write(read);
						
						if (proxyToServerSocket.getInputStream().available() < 1) {
							// you may want to use flush() after writing.
							clientSocket.getOutputStream().flush();
						}
					
				
					}
				} while (read>=0);
				
			}catch(Exception e) {
				System.out.println("Reading the server reply was the problem!");
				
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
			
			
			
		}catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Shit happens while processing " + urlString);
			
		}catch(IOException e) {
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
	
	
	//Generates a random file name  
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
