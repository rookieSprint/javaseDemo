package com.dyl.threaddome;

public class RunnableCusInc implements Runnable{

	private ShareDate shareDate;
	public RunnableCusInc(ShareDate date) {
		this.shareDate = date;
	}
	@Override
	public void run() {
		for(int i = 0;i < 5; i++){
			shareDate.inc();
		}
	}
	public static void main(String[] args) {
		ShareDate date = new ShareDate();
		for(int i=0; i<4;i++){
			new Thread(new RunnableCusInc(date),"Thread" + i).start();
		}
	}

}
