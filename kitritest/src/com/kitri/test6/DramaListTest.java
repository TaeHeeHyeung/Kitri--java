package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {

	public static void main(String[] args) {
		List<Drama> listDrama= new ArrayList<Drama>();
		
		listDrama.add(new Drama("�� �ܿ�,","SBS", "�����", "���μ�", "������"));
		listDrama.add(new Drama("����� ����,","MBC", "������", "", ""));
		listDrama.add(new Drama("���̸���2,","KBS", "ǥ�μ�", "����", "�̴���"));
		listDrama.add(new Drama("�ְ�� �̼���,","KBS", "������", "", "������"));
		
		int len = listDrama.size();
		for (int i = 0; i < len; i++) {
			System.out.println(i+1+". "+listDrama.get(i).toString());
		}
	}//end main
}
