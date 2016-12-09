package com.yesky.test.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//创建socket，指定要连接的服务端地址和端口号
			Socket socket = new Socket("127.0.0.1",7777);
			DataInputStream dataInput = new DataInputStream(socket.getInputStream());
			System.out.println(dataInput.readUTF());
			
			dataInput.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
