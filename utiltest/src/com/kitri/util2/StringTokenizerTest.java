package com.kitri.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class StringTokenizerTest {

	public static void main(String[] args) {
		StringTokenizer stoken= new StringTokenizer("asdf asd");
		System.out.println("��ū���� : "+stoken.countTokens());//default ����
		String str; 
		while(stoken.hasMoreTokens()) {
			str = stoken.nextToken();
			System.out.println(str);	
		}
		String delStr= "/as/"; 
		str = "TO"+delStr+"��ȿ��"+delStr+"�ȳ��ϼ��� ���� ���ϼ���???";
		stoken= new StringTokenizer(str,delStr);
		String protocol =stoken.nextToken();
		String to =stoken.nextToken();
		String msg =stoken.nextToken();
		System.out.println("���: "+ protocol +"��������: "+ to+"������ �޽���: "+msg);
		
		//uuid universal unique identifier
		//random uuid
		System.out.println(UUID.randomUUID());
		
		
	}//end main
}//end class
