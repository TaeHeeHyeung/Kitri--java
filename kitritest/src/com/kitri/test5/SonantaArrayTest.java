package com.kitri.test5;

public class SonantaArrayTest {

	public static void main(String[] args) {
		Sonata[] sonata = new Sonata[4];

		sonata[0] = new Sonata("���", 5000, "�¿�", "NF");
		sonata[1] = new Sonata("����", 7000, "����", "Brilliant");
		sonata[2] = new Sonata("��ȫ��", 4000, "�ý�", "EF");
		sonata[3] = new Sonata("������", 6000, "�¿�", "Hybrid");
		
		
		int len = sonata.length;
		for (int i = 0; i < len; i++) {
			System.out.println(sonata[i]);
		}

	}

}
