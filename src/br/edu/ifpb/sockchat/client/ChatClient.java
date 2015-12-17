package br.edu.ifpb.sockchat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	
	public static void main(String[] args){
		Socket sock = null;
		DataInputStream input = null;
		DataOutputStream output = null;
		
		try {
		sock = new Socket(args[0],Integer.parseInt(args[1]));
		
		input = new DataInputStream(sock.getInputStream());
		output = new DataOutputStream(sock.getOutputStream());
		
		} catch (UnknownHostException e){
			System.out.println("Connection cannot be resolved!");
		} catch (IOException e) {
			System.out.println("Error at channel definition: "+e.getMessage());
		}
		System.out.println("Connection accepted by Server!");
		
		new Thread(new Yelling(output)).start();
		while(true){
			try {
				if(input.available() != 0) System.out.println(input.readUTF());
			} catch (IOException e) {
				System.out.println("Erro: "+e.getMessage());
			}
		}
		
		
		
	}
}
