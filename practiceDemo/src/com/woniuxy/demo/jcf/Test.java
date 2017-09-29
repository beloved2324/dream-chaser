package com.woniuxy.demo.jcf;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Object test;
		test= (Class.forName("com.woniuxy.demo.jcf.Test").newInstance());
		
	}
	
	void test(){
		System.out.println("test");
	}
}
