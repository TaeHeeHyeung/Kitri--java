package com.teahee.thread;

public class Threadt2 extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println("tt2");
		}
	
	}
}