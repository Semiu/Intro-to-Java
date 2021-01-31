/*
 * Similar to InputConnection.java program
 */
package com.HighLevelOne;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.IOException;

public class InputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			URL url = new URL("http://example.org");
					
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String line = "";
			while (line != null) {
				line = inputStream.readLine();
				System.out.println(line);
			}
			
			inputStream.close();
						
			
		}catch(IOException e) { 
			System.out.println("URI Bad Syntax: " + e.getMessage());
			
	}
}
	
}
