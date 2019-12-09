package com.dyl.threaddome;

public class PoolThread implements Runnable {

	private int index;
//	public PoolThread() {
//	}
	public PoolThread(int i) {
		index = i;
	}
	
	@Override
	public void run() {
		
		
		try {
			System.out.println("开始处理线程！！！");
			Thread.sleep(index*1000);
			 System.out.println("我的线程标识是："+this.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
