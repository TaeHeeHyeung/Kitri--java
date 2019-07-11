package com.kitri.io;

import java.io.IOException;

public class StdInOutTest {

	public static void main(String[] args) {
		try {
//			System.out.print("입력 :");
//			int x = System.in.read();//첫 번째 문자의 아스키코드 //인풋스트림 (바이트)
//			System.out.println(x);
//			System.out.println((char)x);

			byte[] b = new byte[100];
			System.out.print("입력 :"); //안녕하세요 입력 \n 포함됨
			int x = System.in.read(b);
			System.out.println(x);
			
			System.out.println(b[0] + x); // 
			System.out.println(b[1] + x); // 
			System.out.println(b[2] + x); // 
			System.out.println(b[3] + x); // 
			String s = new String(b, 0, x - 2);
			System.out.println(s);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();

	}

}
