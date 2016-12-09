package com.yesky.test.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",1234);
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			
			new ClientRead(input).start();
			new ClientWrite(output).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

	class ClientRead extends Thread{
		DataInputStream input;
		public ClientRead(DataInputStream input){
			this.input=input;
		}
		@Override
		public void run() {
			try {
				while(true){
					String msg = input.readUTF();
					System.out.println("对方说:"+msg);
					
					if(msg.equals("bye")){
						System.out.println("对方已下线");
						System.exit(0);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	class ClientWrite extends Thread{
		DataOutputStream output;
		public ClientWrite(DataOutputStream output){
			this.output=output;
		}
		
		@Override
		public void run() {
			try {
				while(true){
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					String msg = reader.readLine();
					output.writeUTF(msg);
					
					if(msg.equals("bye")){
						System.out.println("自己已下线");
						System.exit(0);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
