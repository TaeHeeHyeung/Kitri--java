package com.kitri.lang;

public class StringBufferTest {


	public static void main(String[] args) {
		//공간을 초과하면 여유공간이 계속해서 증가한다.
		StringBuffer sb1 = new StringBuffer("hello");
		System.out.println("sb1 == "+ sb1);
		
		int cap =sb1.capacity();
		System.out.println("크기: "+ cap +" 문자열 길이: "+ sb1.length());
		//컴퓨터는 8의 배수를 좋아함		
		//new StringBuffer(int capacity)
		
		sb1.append("java");
		System.out.println("2. sb1 == "+ sb1);
		cap =sb1.capacity();
		System.out.println("크기: "+ cap +" 문자열 길이: "+ sb1.length());
		
		sb1.append(" !!!!!!");
		System.out.println("4. sb1 == "+ sb1);
		cap =sb1.capacity();
		System.out.println("크기: "+ cap +" 문자열 길이: "+ sb1.length());
		
		sb1.append("!");
		System.out.println("5. sb1 == "+ sb1);
		cap =sb1.capacity();
		System.out.println("크기: "+ cap +" 문자열 길이: "+ sb1.length());
		
		sb1.insert(10, "@@@"); //10의 위치에서 추가한다.
		System.out.println("5. sb1 == "+ sb1);
		
		sb1.delete(10, 12); //11과 12가 지워진다.
		System.out.println("6. sb1 == "+ sb1);
		
		sb1.deleteCharAt(10);
		System.out.println("7. sb1 == "+ sb1);
		
		sb1.replace(6, 7, "자바"); // 6 7 8
		System.out.println("8. sb1 == "+ sb1);
		
		sb1.reverse();
		System.out.println("9. sb1 == "+ sb1);
		sb1.reverse();
		
		sb1.setCharAt(9, '@');
		System.out.println("10. sb1 == "+ sb1);
		
		String s1= new String(sb1);
		String s2= sb1.toString();
		System.out.println(s1);
		System.out.println(s2);
		
		String str= "hello 자바!!!";
		System.out.println("--------------------------------------------");
		
		
		str = "hello 자바 !!!";
		String findStr = "자바";
		//String findStr = "오라클";
		String replace = "java";
		
		int index =str.indexOf(findStr);
		//StringBuffer을 굳이 외부에서 만들 필요가없다.
		if(index == -1) {
			System.out.println(findStr+"가 없습니다.");
		}else {
			StringBuffer sb= new StringBuffer("hello 자바 !!!");
			sb.replace(index, index+findStr.length(), replace);
			System.out.println(sb);
		}
		
		
	}//end main
}//end main class
