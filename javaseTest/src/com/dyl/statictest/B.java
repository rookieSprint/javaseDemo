package com.dyl.statictest;

public class B {
	
	private A a = new A();
	public B(){
		System.out.println("B constructor");
	}
	{
		A a = new A();
		System.out.println("B no static code block");
	}
	static {
		System.out.println("B static code block");
	}
	static void print(){
		System.out.println("B static method");
	}
}
