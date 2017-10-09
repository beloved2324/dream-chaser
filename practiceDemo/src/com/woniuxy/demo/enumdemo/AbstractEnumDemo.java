package com.woniuxy.demo.enumdemo;

public enum AbstractEnumDemo {
	PLUS {
		@Override
		public double eval(double x, double y) {
			// TODO Auto-generated method stub
			return x+y;
		}
	},MINUS {
		@Override
		public double eval(double x, double y) {
			return x*y;
		}
	};
	public abstract double eval(double x,double y);
	public static void main(String[] args) {
		System.out.println(AbstractEnumDemo.MINUS.eval(100, 10));
	}
}
