package com.testthread;

public class ThreadTest {
//하나의 객체내에서 하나의 스레드 실행됨
	public static void main(String[] args) {
//		Threadt1 tt1 = new Threadt1();
//		tt1.start();
//		Threadt2 tt2 = new Threadt2();
//		tt2.start();
		RunnableTest r1 =new RunnableTest();
		r1.start();
		RunnableTest2 r2 =new RunnableTest2();
		r2.start();
		
	}

	public static class RunnableTest extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				System.out.println("실행1");
			}
		}
	}// Runnable Test
	public static class RunnableTest2 extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("222222");
			}
		}
	}// Runnable Test

	
}
