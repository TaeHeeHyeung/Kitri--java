package com.kitri.lang;

public class StringVSBuffer {

	public static void main(String[] args) {
		
		String str = "hello ";
		long startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++) {
			str += i;
		}
		long endTime = System.nanoTime();
		System.out.println((endTime-startTime));
		
		
		StringBuffer sb = new StringBuffer("hello");
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++) {
			sb.append(i);
		}
		System.out.println(sb.toString());
		endTime = System.nanoTime();
		System.out.println((endTime-startTime));

//	500
//	1074154	900634 959330
//	154275	133748 120598

//	5000
//	44677308 	48807140
//	723907		511579
		
		
	}// end main
}// end class
