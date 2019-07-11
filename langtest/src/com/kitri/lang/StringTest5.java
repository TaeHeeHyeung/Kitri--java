package com.kitri.lang;

public class StringTest5 {

	public static void main(String[] args) {
		String str = "hello java !!!";
		int x = str.indexOf('a');
		System.out.println(str + "에서 a는 " + (x + 1) + "번 째 있다.");

		x = str.indexOf('a', 8);
		System.out.println(str + "에서 8번째 부터a는 " + (x + 1) + "번 째 있다.");

		x = str.indexOf("java");
		System.out.println(str + "에서 8번째 부터java는 " + (x + 1) + "번 째 있다.");
		
		x = str.lastIndexOf('a');
		System.out.println(str + "끝에서 부터 찾아가 a는 " + (x + 1) + "번 째 있다.");
		
		String str2 = "";
		System.out.println(str2+ "의 길이:" +str2.length());
		if(str2.isEmpty()) {
			System.out.println("빈문자열이다.");
		}
		
		String str3 = "  hello     ";
//		String str3 = "  hello   .  "; 문자열 사이 공백 제거 불가능
		System.out.println(str3+ "의 길이:" +str3.length());
		System.out.println(str3+ "의 공백 제거 후 길이:" +str3.trim().length());
		
		String str4 = "jabba";
		System.out.println(str4 +"::::"+str4.replace('b', 'v'));
		
		//spi replace의 매개변수 CharSequence=> 인터페이스이다.
		//상세설명 1.4 이후로 나왔다 표시됨.
		System.out.println(str4 +"::::"+str4.replace("jaba", "java"));
		System.out.println(str4 +"::::"+str4.replaceAll("jaba", "java"));
		
		String str5 = "hello java !!!";
		//정규식 regex
		String s[] =str5.split(" ");
		System.out.println(str5.substring(6));
		System.out.println(str5.substring(6,9));
		
		//숫자 -> 문자열
		int num =100;
		String sn1 = num+"";
		String sn2 = String.valueOf(num);
		String sn3 = Integer.toString(num);
		System.out.println(sn1+","+ sn2+","+sn3);
		
		//문자열 -> 숫자
		String ns = "100";
		num = Integer.parseInt(ns);
		
		
	}//end main
}
