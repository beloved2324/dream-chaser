package com.woniuxy.demo.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 554);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					s.getOutputStream()));
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					System.in));
			int i=0;
			while(i<5){
				//				int str = bf.read();
				System.out.println(i+"********");
				String str = bf.readLine();
				//			String str="hello";
				System.out.println(str);
				bw.write(str);
				bw.newLine();
				bw.flush();
				i++;
			}
			bw.close();

			//			bw.close();
			//			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
