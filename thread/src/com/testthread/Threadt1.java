package com.testthread;


public class Threadt1 extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 100; i++) {
			System.out.println("tt1");
		}
		
	}
	
	
}
