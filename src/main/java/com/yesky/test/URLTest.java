package com.yesky.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		//如果不能直接访问外网，需填入代理服务器IP地址 和 端口号
		System.setProperty("http.proxyHost", "192.168.1.1");
		System.setProperty("http.proxyPort", "11080");
		
		URL url = new URL("http://www.google.com");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String str;
		while((str = reader.readLine())!=null){
			System.out.println(str);
		}
	}

}
