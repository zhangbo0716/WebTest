package com.yesky.test.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	/**
	 * 执行顺序:服务端启动执行1创建服务端,并绑定端口号,等待接受客户端连接.
	 * 2已接受到客户端连接,创建IO流，创建2个线程，等待状态，等待接受请求消息.
	 * 3已接受到客户端请求消息.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//1
			ServerSocket server = new ServerSocket(1234);
			//2
			Socket socket = server.accept();
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			new Read(input).start();
			new Write(output).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Read extends Thread{
	DataInputStream input = null;
	public Read(DataInputStream input){
		this.input = input;
	}

	@Override
	public void run() {
		try {
			//3
			while(true){
				String msg = input.readUTF();
				System.out.println("对方说："+msg);
				
				if(msg.equals("bye")){
					input.close();
					System.out.println("对方已下线");
					System.exit(0);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}


class Write extends Thread{
	DataOutputStream output = null;
	
	public Write(DataOutputStream output){
		this.output = output;
	}
	
	@Override
	public void run() {
		try {
			while(true){
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String info = in.readLine();
				output.writeUTF(info);
				
				if(info.equals("bye")){
					System.out.println("自己已下线");
					System.exit(0);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
