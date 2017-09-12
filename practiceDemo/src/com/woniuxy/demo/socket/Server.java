package com.woniuxy.demo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		Socket s;
		try {
			ServerSocket ss = new ServerSocket(554);
			while (true) {
				s = ss.accept();
				System.out.println("a client connect!");
				BufferedReader bf = new BufferedReader(new InputStreamReader(
						s.getInputStream()));
				System.out.println("ok");
				String str;
				while((str=bf.readLine())!=null){
					System.out.println(str);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
