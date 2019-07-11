package com.kitri.lang;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ReverseTest {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String str = "!!! avaJ olleH";
		// 역으로 돌리기 3개
		System.out.println();

		char[] tempCharArr = str.toCharArray();
		int result =0;
		// 방법 1
		int len = tempCharArr.length;
		char[] ch = new char[len];
		for (int i = len - 1; i >= 0; i--) {
			ch[len - 1 - i] = tempCharArr[i];
			if(ch[len - 1 - i] == 'e') {
				result = (len-1)- i+1 ;
			}
		}
	
		System.out.println(String.valueOf(ch) +" "+result);
		System.out.println(String.valueOf(ch).indexOf('e')+1 );
		System.out.println(new String(ch).indexOf('e')+1);
		
	

		// char
		// byte
		// 방법2
		byte[] tempByteArr = str.getBytes();
		len = tempByteArr.length;
		byte[] byteArr = new byte[len];
		for (int i = len - 1; i >= 0; i--) {
			byteArr[len - 1 - i] = tempByteArr[i];
			if(byteArr[len - 1 - i] == 'e') {
				result = (len-1)- i+1 ;
			}
		}
		System.out.println(new String(byteArr) +" "+result);
		System.out.println(new String(byteArr).indexOf('e')+1 +" "+result);
		
		
//		System.out.println(new String(byteArr,"utf-8"));

		// 방법3
		len = str.length();
		char[] charArr = new char[len];
		for (int i = 0; i < len; i++) {
			charArr[i] = str.charAt(len-1 -i);
			if(charArr[i]=='e') {
				result = i+1 ;
			}
		}
		System.out.println(new String(charArr)+ " "+result);
		
		
		String strResult =" ";
		len= str.length();
		for (int i = len - 1; i >= 0; i--) {
			System.out.println(str.charAt(i));
			strResult += str.charAt(i);
		}
		System.out.println(strResult);
		

		
		
		
		
		// e는 2번째 있습니다.
	}// main
}
