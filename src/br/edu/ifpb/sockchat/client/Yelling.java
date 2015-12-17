package br.edu.ifpb.sockchat.client;

import java.awt.HeadlessException;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Yelling implements Runnable{
	private DataOutputStream out;
	
		public Yelling(DataOutputStream out){
			this.out = out;
		}
	
	@Override
	public void run(){
		while(true){
			try {
				out.writeUTF(JOptionPane.showInputDialog("Type next command"));
			} catch (HeadlessException e) {
				System.out.println("Error: "+e.getMessage());
			} catch (IOException e) {
				System.out.println("Error: "+e.getMessage());
			} catch (NullPointerException e){}
		}
	}
}