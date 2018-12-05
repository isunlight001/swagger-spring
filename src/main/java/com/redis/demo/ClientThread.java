package com.redis.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientThread implements Runnable {
	int i = 0;
	public ClientThread(int i) {
		this.i = i;
	}
	public void run() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:s");
		String time = format.format(date);
		JedisUtil.setString("foo", time);
		String foo = JedisUtil.getString("foo");
		System.out.println("【输出>>>>】foo:" + foo + " 第："+i+"个线程" +"当前时间："+time);  
	}
	public static void main(String[] args) {                
        for (int i = 0; i < 10000; i++) {            
            ClientThread t = new ClientThread(i);  
            t.run();  
        }  
    }  

}
