package com.kitri.io;

import java.io.IOException;

public class StdInOutTest {

	public static void main(String[] args) {
		try {
//			System.out.print("�Է� :");
//			int x = System.in.read();//ù ��° ������ �ƽ�Ű�ڵ� //��ǲ��Ʈ�� (����Ʈ)
//			System.out.println(x);
//			System.out.println((char)x);

			byte[] b = new byte[100];
			System.out.print("�Է� :"); //�ȳ��ϼ��� �Է� \n ���Ե�
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
