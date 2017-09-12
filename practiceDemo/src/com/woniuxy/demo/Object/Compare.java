package com.woniuxy.demo.Object;

public class Compare {
	public static void main(String[] args) {
		User u= new User("zhangsan");
		User u1 = new User("zhangsan");
		
		System.out.println(u == u1);
	}
}
class User{
	private String userName;

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return userName.length();
	}

	public User(String userName) {
		this.userName = userName;
	}
	
}