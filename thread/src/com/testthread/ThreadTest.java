package com.testthread;

public class ThreadTest {
//�ϳ��� ��ü������ �ϳ��� ������ �����
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
				System.out.println("����1");
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
