package com.dyl.threaddome;

public class TreadLocalTest implements Runnable{

	private static int nextSerialNum = 0;
	private static ThreadLocal serialNum = new ThreadLocal(){
		protected synchronized Object initiaValue(){
			return new Integer(nextSerialNum++);
		}
	};
	

	@Override
	public void run() {
		
	}
	
	

}
