package com.woniuxy.demo.basic;

public class DelDemo {
	public static void main(String[] args) {
		DelDemo del = new DelDemo();
		del.methodA();
		del.methodB();
	}
	
	
	public void methodA(){
		int row = 7;
		for(int i = 0 ;i<row;i++){
			for(int k = row-i;k>0;k--){
				System.out.print(" ");
			}
			for(int j = 0;j<i*2+1;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void methodB(){
		int row = 7;
		for(int i = row;i>=0;i--){
			for(int k = 0;k<row-i;k++){
				System.out.print(" ");
			}
			for(int j = i*2+1;j>0;j--){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
