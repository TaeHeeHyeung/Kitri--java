package com.kitri.util;

import java.util.*;

public class SetTest {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		System.out.println(set.size());
		set.add("Ȳ����");
		set.add("�ڹ̷�");
		set.add("������");
		set.add("������");
		
//		System.out.println(set.size());
//		Object[] obj = set.toArray();
//		int len = set.size();
//		for (int i = 0; i < len; i++) {
//			System.out.println((String)obj[i]);
//		}
		String str[] = set.toArray(new String[0]);
		int len = str.length;
		for (int i = 0; i < len; i++) {
			System.out.println(str[i]);
		}
		
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		
	}//end main
	
}
