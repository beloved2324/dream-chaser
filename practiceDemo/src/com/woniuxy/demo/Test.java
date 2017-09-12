package com.woniuxy.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.woniuxy.demo.jcf.MyLinkedList;

public class Test {
	public static void main(String[] args) {
//		VArray<String> s = new VArray<String>();
//		s.add("abc");
//		s.add(null);
//		s.add(null);
//		System.out.println(s.get(1));
//		System.out.println(s.size());
//		System.out.println(s);
		
//		SinglyLinkedList<String> s = new SinglyLinkedList<String>();
//		s.add("abc");
//		s.add("bcd");
//		s.remove("bcd");
//		System.out.println(s);
//		System.out.println(s.length());
//		System.out.println(s.get(3));
		
		MyLinkedList<String> s = new MyLinkedList<String>();
		s.add("abc");
		s.add("bcd");
//		s.remove("bcd");
		System.out.println(s);
		System.out.println(s.get(1));
		System.out.println(s.length());
	}
}
