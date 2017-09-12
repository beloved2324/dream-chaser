package com.woniuxy.demo.jcf.survivor;

import java.util.LinkedList;
import java.util.Queue;

public class Survivor {
	/*
	 *有100人排队轮流报数，如果报数不是3的倍数，则站到队伍的尾部，如果报数为3的倍数，则离开队伍，那么最后剩下的是第几个人呢？
	 */
	public static void main(String[] args) {
		Queue<User> users = new LinkedList<User>();
		for(int i = 0;i<100;i++){
			users.add(new User("People"+i,i+1));
		}
		int i = 1;
		while(users.size()!=1){
			if(i%3==0)
				users.poll();
			else{
				users.offer(users.peek());
				users.remove(users.peek());
			}
			i++;
		}
		System.out.println(users);
	}
}
