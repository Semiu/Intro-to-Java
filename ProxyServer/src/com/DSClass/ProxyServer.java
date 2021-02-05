package com.DSClass;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class ProxyServer {

	/**
	 * Declaring the class instance variables
	 */
	//cache is a Map: the key is the URL and the value is the file name of the file that stores the cached content
	Map<String, String> cache;
	
	//socket variable for the server
	ServerSocket proxySocket;
	
	//The file name of the file to store the cached content
	String logFileName = "log.txt";
	
	//Declare a running boolean variable to track when client-server connection is successful
	boolean running;

	//The main method for the program
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//I assume that this startServer should take port number as argument (Perhaps this would come from the browwer)
		//new ProxyServer().startServer(Integer.parseInt(args[0]));
		new ProxyServer().startServer(8080); //testing

	}
	
	//startServer method of the ProxyServer class 
	void startServer(int proxyPort) {
		

		cache = new ConcurrentHashMap<>();

		// create the directory to store cached files. 
		File cacheDir = new File("cached");
		if (!cacheDir.exists() || (cacheDir.exists() && !cacheDir.isDirectory())) {
			//checking if file exists in Cache directory
			System.out.println("File not found in cached directory - creating new directory");
			cacheDir.mkdirs();
		}	
				
		// Create the Server Socket for the Proxy 
		//Maybe this will go to RequestHandler.java
		try {
			
			proxySocket = new ServerSocket(proxyPort);
			
			System.out.println("Waiting for client on port " + proxySocket.getLocalPort() + "..");
			running = true;
		} 

		// Catch exceptions associated with opening socket
		catch (SocketException se) {
			System.out.println("Socket Exception when connecting to client");
			se.printStackTrace();
		}
		catch (IOException io) {
			System.out.println("IO exception when connecting to client");
		}
		//server socket creation ends

		//When connection is successful 
		/**
		 * A serverSocket to listen on the port (proxyPort) and accept new socket connections
		 *  (Remember to catch Exceptions!)
		 */
		while(running){
			try {
				// proxySocket.accept() Blocks until a connection is made
				Socket socket = proxySocket.accept();
				
				/**
				 * A thread (RequestHandler) for each new client connection 
				 */
				Thread thread = new Thread(new RequestHandler(socket));
				
				// Key a reference to each thread so they can be joined later if necessary
				//This is if there is a need to take track of the threads. ArrayList of operating threads would be created
				//operatingThreads.add(thread);
				
				//Start the thread
				thread.start();	
				
			} catch (SocketException e) {
				
				// Socket exception to shut down the proxy 
				System.out.println("Server closed");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	//end of startServer method
	
	//Method to get the cache's hashcode
	public String getCache(String hashcode) {
		return cache.get(hashcode);
	}

	//Method to save into the cache Map.
	public void putCache(String hashcode, String fileName) {
		cache.put(hashcode, fileName);
	}

	//Method to write info into the log file.
	public synchronized void writeLog(String info) {
			/**
			 * To do: write string (info) to the log file, and add the current time stamp 
			 * e.g. String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			*/
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		boolean append = true;
		try {
			Logger logger = Logger.getLogger("com.DSClass.snippets.core");
			//Current time stamp is added to the log
			FileHandler handler = new FileHandler(logFileName+timeStamp, append);
			
			logger.addHandler(handler);
			 
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	

}
