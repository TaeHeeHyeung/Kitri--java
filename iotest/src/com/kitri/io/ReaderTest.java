package com.kitri.io;

import java.io.*;

public class ReaderTest {

	public static void main(String[] args) {
		Reader in;
		try {
			in = new InputStreamReader(System.in);
//			int x = in.read(); // ���ڷ� ����
//			System.out.println(x);

			char[] c = new char[100];
			int x = in.read(c); // ĳ����
			System.out.println("x == "+x);
			
			int len = c.length;
			for (int i = 0; i < x-2; i++) {
				System.out.print(c[i]);
			}
			// carrige return /n/r ���� ���� �߾ȵ�
//			String str= new String(c,0,x-2);
//			System.out.print(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}//end main

}
