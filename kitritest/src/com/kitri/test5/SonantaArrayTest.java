package com.kitri.test5;

public class SonantaArrayTest {

	public static void main(String[] args) {
		Sonata[] sonata = new Sonata[4];

		sonata[0] = new Sonata("Èò»ö", 5000, "½Â¿ë", "NF");
		sonata[1] = new Sonata("Àº»ö", 7000, "¾÷¹«", "Brilliant");
		sonata[2] = new Sonata("°¨È«»ö", 4000, "ÅÃ½Ã", "EF");
		sonata[3] = new Sonata("°ËÁ¤»ö", 6000, "½Â¿ë", "Hybrid");
		
		
		int len = sonata.length;
		for (int i = 0; i < len; i++) {
			System.out.println(sonata[i]);
		}

	}

}
