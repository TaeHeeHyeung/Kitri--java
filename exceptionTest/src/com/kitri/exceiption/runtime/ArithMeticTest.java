package com.kitri.exceiption.runtime;

import java.util.Random;

public class ArithMeticTest {

	public static void main(String[] args) {
		Random random = new Random();
		int x = 30;

//		//RuntimeException�� Runtime �����̱� ������ logic���� ó��... 
//		int y = random.nextInt(5);
//		try {
//			double z = x / y; //arithMetic except Throws
//			System.out.println(y);
//		}catch (ArithmeticException e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//			System.out.println("0 ���� ���� �� �����ϴ�.");
//		}
		
//		1.
		int y = random.nextInt(5) ;
		if(y !=0) {
			int z = x / y;
			System.out.println(z);	
		}else {
			System.out.println("0���γ������� �����ϴ�.");
		}
		
//		2.
		y = random.nextInt(4) + 1;
		int z = x / y;
		System.out.println(z);

	}// end main
}// end class
