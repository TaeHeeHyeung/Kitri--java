package com.kitri.lang;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest4 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "hello";
		byte b[] = str.getBytes();
		
		System.out.println(Arrays.toString(b));
		
		String str2= "救崇窍技夸.";
		byte[] b2 = str2.getBytes();
		System.out.println();
		System.out.println(Arrays.toString(b2)); //euc-kr 2byte究 律胺
		System.out.println(new String(b2));
		b2 = str2.getBytes("utf-8");
		System.out.println(Arrays.toString(b2));// utf-8 3byte究 律胺
		System.out.println(new String(b2,"utf-8"));
		
		char[] ch = str2.toCharArray();
		
		int len = ch.length;
		for (int i = 0; i < len; i++) {
			System.out.println(ch);	
		}
	}
}
