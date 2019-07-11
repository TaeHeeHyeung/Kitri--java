package com.kitri.lang;

public class StringBufferTest {


	public static void main(String[] args) {
		//������ �ʰ��ϸ� ���������� ����ؼ� �����Ѵ�.
		StringBuffer sb1 = new StringBuffer("hello");
		System.out.println("sb1 == "+ sb1);
		
		int cap =sb1.capacity();
		System.out.println("ũ��: "+ cap +" ���ڿ� ����: "+ sb1.length());
		//��ǻ�ʹ� 8�� ����� ������		
		//new StringBuffer(int capacity)
		
		sb1.append("java");
		System.out.println("2. sb1 == "+ sb1);
		cap =sb1.capacity();
		System.out.println("ũ��: "+ cap +" ���ڿ� ����: "+ sb1.length());
		
		sb1.append(" !!!!!!");
		System.out.println("4. sb1 == "+ sb1);
		cap =sb1.capacity();
		System.out.println("ũ��: "+ cap +" ���ڿ� ����: "+ sb1.length());
		
		sb1.append("!");
		System.out.println("5. sb1 == "+ sb1);
		cap =sb1.capacity();
		System.out.println("ũ��: "+ cap +" ���ڿ� ����: "+ sb1.length());
		
		sb1.insert(10, "@@@"); //10�� ��ġ���� �߰��Ѵ�.
		System.out.println("5. sb1 == "+ sb1);
		
		sb1.delete(10, 12); //11�� 12�� ��������.
		System.out.println("6. sb1 == "+ sb1);
		
		sb1.deleteCharAt(10);
		System.out.println("7. sb1 == "+ sb1);
		
		sb1.replace(6, 7, "�ڹ�"); // 6 7 8
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
		
		String str= "hello �ڹ�!!!";
		System.out.println("--------------------------------------------");
		
		
		str = "hello �ڹ� !!!";
		String findStr = "�ڹ�";
		//String findStr = "����Ŭ";
		String replace = "java";
		
		int index =str.indexOf(findStr);
		//StringBuffer�� ���� �ܺο��� ���� �ʿ䰡����.
		if(index == -1) {
			System.out.println(findStr+"�� �����ϴ�.");
		}else {
			StringBuffer sb= new StringBuffer("hello �ڹ� !!!");
			sb.replace(index, index+findStr.length(), replace);
			System.out.println(sb);
		}
		
		
	}//end main
}//end main class
