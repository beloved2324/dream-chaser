package com.woniuxy.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class HyperLinkDemo {
	public static void main(String[] args) {
		File srcFile = new File("String-test.txt");
		File resultFile = new File("result.txt");
		HyperLinkDemo hl = new HyperLinkDemo();
		hl.copyHyperLink(srcFile,resultFile);
	}
	/**
	 * ����������
	 * @param srcFile	��Ҫ�����Դ�ļ�
	 * @param resultFile	����洢��Ŀ���ļ�
	 */
	private void copyHyperLink(File srcFile, File resultFile) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(srcFile));
			String s = null;
			while ((s =br.readLine())!=null) {
				this.copy(s,resultFile);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Դ�ļ������ڣ����ǵ�ַ����");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��������
	 * @param next	�ļ��е�һ������
	 * @param resultFile	�洢������ļ�
	 */
	private void copy(String next, File resultFile) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(resultFile,true));
			StringBuffer buff = this.getBuffer(next);
			bw.write(buff.toString());
			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * ��ȡ�����ַ��������ַ���ѭ�����г������ӣ�Ȼ�󽫳������ı�ƴ�ӵ��ɱ��ַ�����β��
	 * @param next
	 * @return
	 */
	private StringBuffer getBuffer(String next) {
		StringBuffer buff = new StringBuffer();
		while(next.indexOf("http:")!=-1){
			int start = next.indexOf("http:");
			next = next.substring(start);
			int end = next.indexOf("\"");
			String s = next.substring(next.indexOf("http"),end);//获取超链接
			next = next.substring(end);
			System.out.println(s);
			buff.append(s+"\r\n");
		}
		return buff;
	}
	
}
