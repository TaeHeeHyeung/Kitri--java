package com.kitri.util;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> list= new ArrayList<String> ();
		list.add("허경민");
		list.add("정수빈");
		list.add("박건우");
		list.add("김재환");
		list.add("오재원");
		//두산의 타순
		int len = list.size();
//		Integer [] listI= list.toArray(new Integer[0]);
		for (int i = 0; i < len; i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		
		String name = "정수빈";
		String name2 = "오재원";
		
		int nI= list.indexOf("정수빈");
		int nI2 = list.indexOf("오재원");
		System.out.println(name+"은 "+nI+"번타자입니다.");
		list.set(nI, "오재원");
		list.set(nI2, "정수빈");
		
		
		System.out.println(name+"을"+name2+"으로 교체.");
		for (int i = 0; i < len; i++) {
			System.out.print(list.get(i)+" ");
		}
	}//end main

}
