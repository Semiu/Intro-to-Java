package com.udpServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
			
			DatagramSocket socket = new DatagramSocket(5000);
			
			while(true) {
				byte[] buffer = new byte[50];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				System.out.println("Text received is: " + new String (buffer, 0, packet.getLength()));
				
			}
			
		}catch (SocketException e) {
			System.out.println("Socket Exception: " + e.getMessage());
			
		} catch(IOException e) {
			System.out.println("IO Exception: "+ e.getMessage());
			
		}

	}

}
