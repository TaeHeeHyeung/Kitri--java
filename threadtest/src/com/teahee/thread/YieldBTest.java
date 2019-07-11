package com.teahee.thread;

public class YieldBTest extends Thread {
	boolean work=true;
	boolean stop;
	@Override
	public void run() {
		super.run();
		while(!stop) {
			if(work) {
				System.out.println("B");
			}else {
				yield();
			}
		}
	}
	

}
