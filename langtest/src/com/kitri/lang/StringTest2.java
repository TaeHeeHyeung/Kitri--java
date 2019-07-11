package com.kitri.lang;

import java.io.UnsupportedEncodingException;
//String class 
//�� ������ �����Ҷ� �ѱ۱������� (�ſ��߿�!!)
public class StringTest2 {

	public static void main(String[] args) throws UnsupportedEncodingException {
//		String str1 = null;
		//API
		String str1 = new String(); // ����ִ� ���ڿ� ����
		System.out.println(str1.length());
		System.out.println(str1);

		byte b1[] = { 97, 98, 99, 100 };
		String byteStr1 = new String(b1);
		System.out.println("byteStr1 == " + byteStr1);

		char c2[] = { 97, 98, 99, 100 };
		String charStr2 = new String(c2);
		System.out.println("charStr2 == " + charStr2);

		// �� ������ �����Ҷ� �ѱ۱������� (�ſ��߿�!!)
		// �Ϲ����� �ѱ��� �ϼ��� �ѱ۷� �����ȴ� ex)�ɟ�
		// utf-8�� ��� ������ ���ڸ� ������ �� �ִ�.
		// (���ڸ� �׸���)
		//-20, -107, -120 �� /-21, -123, -107��/ .....
		byte b2[] = { -20, -107, -120, -21, -123, -107, -19, -107, -104, -20, -124, -72, -20, -102, -108, 46 };
		// String byteStr2 = new String(b2);// ���� ���� euc-kr
		// String byteStr2 = new String(b2, "euc-kr");// default euc-kr ��� ���ڸ� 3byte ó����
		String byteStr2 = new String(b2, "utf-8");// throws UnsupportedEncodingException
		System.out.println("byteStr2 == " + byteStr2);
		//��� 
		
		// offset ������,length ���� (�ƽ�Ű�ڵ� ǥ��)
		byte b3[] = { 97, 98, 99, 100, 101, 102, 103, 104 }; //byte�� �ΰ��� ���ľ� ���� �ϳ����ȴ�.
		String byteStr3 = new String(b3, 2,4);
		System.out.println("byteStr3 == " + byteStr3);


		byte c3[] = { -66, -56, -77, -25, -57, -49, -68, -68, -65, -28, 46 };
		String charStr3 = new String(c3);
		System.out.println("charStr3 == " + charStr3);

		char c[] = {'a','b','c','d','e','f'};
		String charStr = new String(c);
		System.out.println("charStr == "+charStr);
		
		String charStr4 = new String(c,2,4);
		System.out.println("charStr4 == "+charStr4);
		//api�������� char�� byte�� ���� �Ű����� ǥ�����̴ٸ���.
		//byte => ���� 
		//char => ����
		
		String s1= "jAva";
		String s2= "javA";
		System.out.println("s1.toUpperCase() =="+ s1.toUpperCase() );
		System.out.println("s2.toLowerCase() =="+ s2.toLowerCase() );
		
		if(s1.equals(s2)) {
			System.out.println("s1�� s2�� ���� ���ڿ��̴�.");
		}else {
			System.out.println("s1�� s2�� �ٸ� ���ڿ��̴�.");
		}
		
		if(s1.toUpperCase().equals(s2.toUpperCase())) {
			System.out.println("s1�� s2�� ��ҹ��� ���о��� ���� ���ڿ��̴�.");
		}else {
			System.out.println("s1�� s2�� ��ҹ��� ���о��� �ٸ� ���ڿ��̴�.");
		}
		
		if(s1.equalsIgnoreCase(s2)) {
			System.out.println("s1�� s2�� ��ҹ��� ���о��� ���� ���ڿ��̴�.");
		}else {
			System.out.println("s1�� s2�� ��ҹ��� ���о��� �ٸ� ���ڿ��̴�.");
		}
		
		
	}//end main
}
