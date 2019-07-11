package com.thisisjava1;

import java.util.Scanner;

public class Condition_test {
	public static void main(String[] args) {
		
		//problum3();
		//problum4();
		//problum5();
		int num = problum7();
	}

	static void problum3() {
		int sum = 0;
		for (int i = 3; i <= 100; i += 3) {
			sum += i;
		}
		System.out.println(sum);
	}//end problum3

	static void problum4() {
		int r1, r2;
		do {
			r1 = (int) (Math.random() * 4) + 1;
			r2 = (int) (Math.random() * 4) + 1;
		} while (r1 + r2 != 5 || r1 == r2);
//		System.out.println("sum " + (r1 + r2));
		System.out.println("r1:" + r1 + " r2:" + r2 + " sum:" + (r1 + r2));
	}//end problum4

	static void problum5() {
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60)
					System.out.println("(" + x + "," + y + ")");
			}
		}
	}//end problum5

	static void problum6() {
		for (int x = 1; x <= 5; x++) {
			for (int y = x; y > 0; y--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}//end problum6

	static int problum7() {
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("------------------------");
			System.out.println("1.예금|2.출금|3.잔고|4.종료");
			System.out.println("------------------------");
			System.out.print("선택> ");
			int menu = sc.nextInt();
			if(menu ==1) {
				System.out.print("예금액");
				int money= sc.nextInt();	
				balance += money;
			}else if(menu ==2) {
				System.out.print("출금액");
				int money= sc.nextInt();
				balance -= money;
			}else if(menu ==3) {
				System.out.print("잔고");
				System.out.println(balance);
			}else if(menu == 4) {
				System.out.println("프로그램종료");
				System.exit(0);
			}//end if
			
		}//end while
		
	}//end problum7
}
