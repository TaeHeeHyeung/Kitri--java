package com.kitri.util;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random rd = new Random();
		System.out.println(rd.nextBoolean());
		System.out.println(rd.nextDouble());
		System.out.println(rd.nextInt());
		System.out.println(rd.nextInt(3));
//		System.out.println(rd.nextInt(-3));//¿¡·¯
	}//end main
}//end class
