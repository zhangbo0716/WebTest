/**
 * 
 */
package com.yesky.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * @author BOBO
 *
 */
public class MacTest {
	public static void main(String[] arguments) throws Exception{
        InetAddress ia = InetAddress.getLocalHost();//获取本地IP对象
        MacTest test = new MacTest();
        System.out.println("MAC ......... "+test.getLocalMacAddress());
//        System.out.println(123);
    }
    
 //获取MAC地址的方法
 public String getMACAddress(InetAddress ia)throws Exception{
     //获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
     byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
     
     //下面代码是把mac地址拼装成String
     StringBuffer sb = new StringBuffer();
     
     for(int i=0;i<mac.length;i++){
         if(i!=0){
             sb.append("-");
         }
         //mac[i] & 0xFF 是为了把byte转化为正整数
         String s = Integer.toHexString(mac[i] & 0xFF);
         sb.append(s.length()==1?0+s:s);
     }
     
     //把字符串所有小写字母改为大写成为正规的mac地址并返回
     return sb.toString().toUpperCase();
}

 public String getLocalMacAddress(){
	 String address = "";
     String os = System.getProperty("os.name");
     if (os != null && os.startsWith("Windows")) {
         try {
             String command = "cmd.exe /c ipconfig /all";
             Process p = Runtime.getRuntime().exec(command);
             BufferedReader br =
                     new BufferedReader(
                             new InputStreamReader(p.getInputStream()));
             String line;
             while ((line = br.readLine()) != null) {
                 if (line.indexOf("Physical Address") > 0) {
                     int index = line.indexOf(":");
                     index += 2;
                     address = line.substring(index);
                     break;
                 }
             }
             br.close();
             return address.trim();
         } catch (IOException e) {}
     }
     return address;

 }  

}
