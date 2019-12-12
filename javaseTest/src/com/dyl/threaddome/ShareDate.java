package com.dyl.threaddome;

public class ShareDate {
	private int num = 10;
	public synchronized void inc(){
		num++;
		System.out.println(Thread.currentThread().getName() + "invoke inc method num =" + num);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void dec(){
		num--;
		System.out.println(Thread.currentThread().getName() + "invoke dec method num =" + num);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
//	public void inc(){
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		num++;
//		System.out.println(Thread.currentThread().getName() + "invoke inc method num =" + num);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
