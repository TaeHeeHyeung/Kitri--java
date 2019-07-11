package com.kitri.lang;

public class StringTest3 {

	public static void main(String[] args) {
		String str = "hello java !!!";
		char c = str.charAt(4);
		System.out.println("c == " + c);

		String str1 = "123";
		int num = str1.charAt(0) - 48;
		System.out.println("str1 == " + num);

		str = "1a3";
		int len = str.length();
		String result = "숫자입니다.";
		for (int i = 0; i < len; i++) {
			num = str.charAt(i) - 48;
//			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if (num < 0 || num > 9) {
				result = "숫자가 아닙니다.";
				break;
			} 
		} // end for
		System.out.println(result);
		str1 = "hello";
		String str2 = "java";
		System.out.println(str1+" "+str2);
		System.out.println(str1.concat(str2));

		str ="hello java !!!";
		if(str.startsWith("h")) {
			System.out.println(str +"은 h로 시작한다.");
		}
		if(str.endsWith("!")) {
			System.out.println(str +"은 !로 끝난다.");
		}
		
		
		
		
	}// end main
}// end class main
