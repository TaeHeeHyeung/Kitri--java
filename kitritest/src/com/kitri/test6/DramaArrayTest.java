package com.kitri.test6;

public class DramaArrayTest {

	public static void main(String[] args) {
		TVProgram[] tvPrograms = new Drama[4];
		tvPrograms[0] = new Drama("�� �ܿ�,","SBS", "�����", "���μ�", "������");
		tvPrograms[1] = new Drama("����� ����,","MBC", "������", "", "");
		tvPrograms[2] = new Drama("���̸���2,","KBS", "ǥ�μ�", "����", "�̴���");
		tvPrograms[3] = new Drama("�ְ�� �̼���,","KBS", "������", "", "������");
		int len = tvPrograms.length;
		for (int i = 0; i < len; i++) {
			System.out.println(i+1+". "+tvPrograms[i].toString());
		}
		
	}

	
}
