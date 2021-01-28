/**
 * This treats the UDP Server situation whereby response is provided from the server
 */

package com.udpServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServerForResponse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
			
			DatagramSocket socket = new DatagramSocket(5000);
			
			while(true) {
				byte[] buffer = new byte[50];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				System.out.println("Text received is: " + new String (buffer, 0, packet.getLength()));
				
				//To return message packet to the client 
				//It takes the bytes and address from the packet received because there is no permanent contact between them
				String returnString = "echo: " + new String(buffer, 0, packet.getLength());
				byte[] buffer2 = returnString.getBytes();
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				packet = new DatagramPacket(buffer2, buffer2.length, address, port);
				socket.send(packet);
			}
			
		}catch (SocketException e) {
			System.out.println("Socket Exception: " + e.getMessage());
			
		} catch(IOException e) {
			System.out.println("IO Exception: "+ e.getMessage());
			
		}

	}

}
