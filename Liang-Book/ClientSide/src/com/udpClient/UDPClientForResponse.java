package com.udpClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class UDPClientForResponse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress address = InetAddress.getLocalHost(); //getByName()
			DatagramSocket datagramSocket = new DatagramSocket();
			
			Scanner scanner = new Scanner(System.in);
			String echoString;
			
			do {
				System.out.println("Enter string to be echoed: " );
				echoString = scanner.nextLine();
				
				byte[] buffer = echoString.getBytes();
				
				//The next line is because Datagram is a self-contained packet
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
				datagramSocket.send(packet);
				
				//To receive packet
				byte[] buffer2 = new byte[50];
				packet = new DatagramPacket(buffer2, buffer.length);
				datagramSocket.receive(packet);
				System.out.println("Text received is: " + new String(buffer2, 0, packet.getLength()));
				
			}while(!echoString.contentEquals("exit"));
			
			
		}catch(SocketTimeoutException e) {
			System.out.println("The socket timed out");
			
		}catch(IOException e) {
			System.out.println("Client error: " + e.getMessage());
			
		}

	}

}
