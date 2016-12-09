package com.yesky.test;

import java.net.InetAddress;

public class IPTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		IPTest ip = new IPTest();
		
		InetAddress inet = InetAddress.getLocalHost();
		ip.show(inet);
		
		inet = InetAddress.getByName("www.sina.com.cn");
		ip.show(inet);
	}
	
	public void show(InetAddress in){
		System.out.println(in.getHostName());
		System.out.println(in.getHostAddress());
		System.out.println("");
	}

}
