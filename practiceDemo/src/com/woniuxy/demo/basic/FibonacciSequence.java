package com.woniuxy.demo.basic;

public class FibonacciSequence {
	/**
	 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
	 * 小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？ 
	 * 
	 *    月份0，1，2，3，4，5，6
	 * 兔子对数 1，1，2，3，5，8，13
	 */
	
	public static void main(String[] args) {
		int month =10;
		
		for(int i = 0;i < month; i++){
			System.out.println(get(i));
		}
	}

	private static int get(int i) {
		if(i == 1||i == 0){
			return 1;
		}else{
			return get(i-1)+get(i-2);
		}
		
	}
}
