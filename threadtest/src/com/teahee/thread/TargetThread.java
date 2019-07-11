package com.teahee.thread;

public class TargetThread extends Thread {
	public void run() {
		for (long l = 0; l < 10000000000l; l++) {

		}
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (long l = 0; l < 10000000000l; l++) {

		}
	}
	

}
