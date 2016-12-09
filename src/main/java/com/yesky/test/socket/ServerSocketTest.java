package com.yesky.test.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author BOBO
 *
 */
public class ServerSocketTest {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7777);
			while(true){
				//接受客户端请求，如没有请求则一直等待
				Socket socket = server.accept();
				//创建输出流，输出给客户端
				OutputStream out = socket.getOutputStream();
				DataOutputStream dataOut = new DataOutputStream(out);
				dataOut.writeUTF("客户端主机名:"+socket.getInetAddress()+"\n 端口号："+socket.getPort());
				
				out.close();
				socket.close();
				server.close();
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
