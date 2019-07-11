package com.kitri.lang;

import java.io.UnsupportedEncodingException;
//String class 
//웹 페이지 개발할때 한글깨짐관리 (매우중요!!)
public class StringTest2 {

	public static void main(String[] args) throws UnsupportedEncodingException {
//		String str1 = null;
		//API
		String str1 = new String(); // 비어있는 문자열 생성
		System.out.println(str1.length());
		System.out.println(str1);

		byte b1[] = { 97, 98, 99, 100 };
		String byteStr1 = new String(b1);
		System.out.println("byteStr1 == " + byteStr1);

		char c2[] = { 97, 98, 99, 100 };
		String charStr2 = new String(c2);
		System.out.println("charStr2 == " + charStr2);

		// 웹 페이지 개발할때 한글깨짐관리 (매우중요!!)
		// 일반적인 한글은 완성형 한글로 생성된다 ex)케잌
		// utf-8은 모든 나라의 문자를 생성할 수 있다.
		// (글자를 그린다)
		//-20, -107, -120 안 /-21, -123, -107녕/ .....
		byte b2[] = { -20, -107, -120, -21, -123, -107, -19, -107, -104, -20, -124, -72, -20, -102, -108, 46 };
		// String byteStr2 = new String(b2);// 글자 깨짐 euc-kr
		// String byteStr2 = new String(b2, "euc-kr");// default euc-kr 모든 글자를 3byte 처리함
		String byteStr2 = new String(b2, "utf-8");// throws UnsupportedEncodingException
		System.out.println("byteStr2 == " + byteStr2);
		//닳다 
		
		// offset 시작점,length 길이 (아스키코드 표현)
		byte b3[] = { 97, 98, 99, 100, 101, 102, 103, 104 }; //byte는 두개를 합쳐야 문자 하나가된다.
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
		//api문서에서 char와 byte에 따라 매개변수 표현법이다르다.
		//byte => 길이 
		//char => 개수
		
		String s1= "jAva";
		String s2= "javA";
		System.out.println("s1.toUpperCase() =="+ s1.toUpperCase() );
		System.out.println("s2.toLowerCase() =="+ s2.toLowerCase() );
		
		if(s1.equals(s2)) {
			System.out.println("s1과 s2는 같은 문자열이다.");
		}else {
			System.out.println("s1과 s2는 다른 문자열이다.");
		}
		
		if(s1.toUpperCase().equals(s2.toUpperCase())) {
			System.out.println("s1과 s2는 대소문자 구분없이 같은 문자열이다.");
		}else {
			System.out.println("s1과 s2는 대소문자 구분없이 다른 문자열이다.");
		}
		
		if(s1.equalsIgnoreCase(s2)) {
			System.out.println("s1과 s2는 대소문자 구분없이 같은 문자열이다.");
		}else {
			System.out.println("s1과 s2는 대소문자 구분없이 다른 문자열이다.");
		}
		
		
	}//end main
}
