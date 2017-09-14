package com.woniuxy.demo.basic;

import java.util.GregorianCalendar;

public class LeapYear {
	/**
	 * ����һ�򣬰��겻���İ�������
	 * @param args
	 */
	public static void main(String[] args) {
		LeapYear test = new LeapYear();
		for(int i = 0;i<5000;i++){
			GregorianCalendar c= new GregorianCalendar(i, 0, 0);
			boolean flag = test.isLeapYear(i+"");
			if(flag && flag == c.isLeapYear(i)){
				System.out.println("���꣺"+i+"----------success");
			}
			if(flag&& flag != c.isLeapYear(i)){
				System.out.println("���꣺"+i+"++++++fail");
			}
		}
	}
	public boolean isLeapYear(String year){
		boolean isLeapYear=false;
		if(this.validateYear(year)){
			int num = Integer.parseInt(year);
			if((num%4==0&&num%100!=0)||num%400==0){
				isLeapYear = true;
			}
		}
		return isLeapYear;
	}
	private boolean validateYear(String year) {
		if(year.matches("^[1-9][0-9]*")){
			return true;
		}
		return false;
	}
}
