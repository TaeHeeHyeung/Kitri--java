package com.kitri.util;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> list= new ArrayList<String> ();
		list.add("����");
		list.add("������");
		list.add("�ڰǿ�");
		list.add("����ȯ");
		list.add("�����");
		//�λ��� Ÿ��
		int len = list.size();
//		Integer [] listI= list.toArray(new Integer[0]);
		for (int i = 0; i < len; i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		
		String name = "������";
		String name2 = "�����";
		
		int nI= list.indexOf("������");
		int nI2 = list.indexOf("�����");
		System.out.println(name+"�� "+nI+"��Ÿ���Դϴ�.");
		list.set(nI, "�����");
		list.set(nI2, "������");
		
		
		System.out.println(name+"��"+name2+"���� ��ü.");
		for (int i = 0; i < len; i++) {
			System.out.print(list.get(i)+" ");
		}
	}//end main

}
