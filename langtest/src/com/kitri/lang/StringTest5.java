package com.kitri.lang;

public class StringTest5 {

	public static void main(String[] args) {
		String str = "hello java !!!";
		int x = str.indexOf('a');
		System.out.println(str + "���� a�� " + (x + 1) + "�� ° �ִ�.");

		x = str.indexOf('a', 8);
		System.out.println(str + "���� 8��° ����a�� " + (x + 1) + "�� ° �ִ�.");

		x = str.indexOf("java");
		System.out.println(str + "���� 8��° ����java�� " + (x + 1) + "�� ° �ִ�.");
		
		x = str.lastIndexOf('a');
		System.out.println(str + "������ ���� ã�ư� a�� " + (x + 1) + "�� ° �ִ�.");
		
		String str2 = "";
		System.out.println(str2+ "�� ����:" +str2.length());
		if(str2.isEmpty()) {
			System.out.println("���ڿ��̴�.");
		}
		
		String str3 = "  hello     ";
//		String str3 = "  hello   .  "; ���ڿ� ���� ���� ���� �Ұ���
		System.out.println(str3+ "�� ����:" +str3.length());
		System.out.println(str3+ "�� ���� ���� �� ����:" +str3.trim().length());
		
		String str4 = "jabba";
		System.out.println(str4 +"::::"+str4.replace('b', 'v'));
		
		//spi replace�� �Ű����� CharSequence=> �������̽��̴�.
		//�󼼼��� 1.4 ���ķ� ���Դ� ǥ�õ�.
		System.out.println(str4 +"::::"+str4.replace("jaba", "java"));
		System.out.println(str4 +"::::"+str4.replaceAll("jaba", "java"));
		
		String str5 = "hello java !!!";
		//���Խ� regex
		String s[] =str5.split(" ");
		System.out.println(str5.substring(6));
		System.out.println(str5.substring(6,9));
		
		//���� -> ���ڿ�
		int num =100;
		String sn1 = num+"";
		String sn2 = String.valueOf(num);
		String sn3 = Integer.toString(num);
		System.out.println(sn1+","+ sn2+","+sn3);
		
		//���ڿ� -> ����
		String ns = "100";
		num = Integer.parseInt(ns);
		
		
	}//end main
}
