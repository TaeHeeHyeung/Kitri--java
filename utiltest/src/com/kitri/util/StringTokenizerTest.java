package com.kitri.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class StringTokenizerTest {

	public static void main(String[] args) {
		StringTokenizer stoken= new StringTokenizer("asdf asd");
		System.out.println("토큰개수 : "+stoken.countTokens());//default 공백
		String str; 
		while(stoken.hasMoreTokens()) {
			str = stoken.nextToken();
			System.out.println(str);	
		}
		String delStr= "/as/"; 
		str = "TO"+delStr+"안효인"+delStr+"안녕하세요 오늘 뭐하세요???";
		stoken= new StringTokenizer(str,delStr);
		String protocol =stoken.nextToken();
		String to =stoken.nextToken();
		String msg =stoken.nextToken();
		System.out.println("기능: "+ protocol +"누구에게: "+ to+"보내는 메시지: "+msg);
		
		//uuid universal unique identifier
		//random uuid
		System.out.println(UUID.randomUUID());
		
		
	}//end main
}//end class
