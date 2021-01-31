package com.HighLevelOne;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class NetworkAPIURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
			
			
			URI baseUri = new URI("http://username:password@mynewserver.com:5000");
			URI uri1 = new URI("/catalogue/phones?os=android#samsung");
			URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
			URI uri3 = new URI("/stores/locations?zip=12345");
			
			URI resolvedUri1 = baseUri.resolve(uri1);
			URI resolvedUri2 = baseUri.resolve(uri2);
			URI resolvedUri3 = baseUri.resolve(uri3);
			
			URL url1 = resolvedUri1.toURL();
			System.out.println("URL = " + url1);
			
			URL url2 = resolvedUri2.toURL();
			System.out.println("URL = " + url2);
			
			URL url3 = resolvedUri3.toURL();
			System.out.println("URL = " + url3);
			
			//Relative URI
			URI relativizeURI = baseUri.relativize(resolvedUri3);
			System.out.println("Relative URI = " + relativizeURI);
			
			
			
		}catch(URISyntaxException e) {
			System.out.println("URI Bad Syntax: " + e.getMessage());
			
		} catch(MalformedURLException e) {
			System.out.println("URL malformed " + e.getMessage());
		}

	}

}
