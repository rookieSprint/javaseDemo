package com.dyl.statictest;

public class A {
	
	public A(){
		System.out.println("A constructor");
	}
	{
		System.out.println("A no static code block");
	}
	static {
		System.out.println("A static code block");
	}
	
	static void print(){
		System.out.println("A static method");
	}
}
