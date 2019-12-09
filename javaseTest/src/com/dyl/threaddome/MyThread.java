package com.dyl.threaddome;

import java.util.concurrent.Callable;

public class MyThread implements Callable {

	private int i = 0;
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return i = 5;
	}

	

}
