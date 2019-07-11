package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

//0. com, my 3자리 배열.
//1. com, my, 세 자리 난수 발생 >>comRandom()
//2. 1의 숫자는 중복 숫자 X
//				0으로 시작X
//3. 내가 입력한 3자리 숫자를 my 배열에 넣기
//4. com과 my의 숫자와 자리비교
//5. 숫자가 같다면
// 	5-1 자리수가 같다면 strike 증가
//	5-2	자리수가 다르다면 ball 증가
//6. 
//	6-1 5의 결과 strike가 3 : 
// 		xxx는 x번째만에 정답입니다. 
// 		계속(1), 종료(0)
// 	6-2 strike가 3이 아니라면
//		1. xxx는 x스트라이크 x볼입니다. >> 3번으로

// 내가 푼것
public class NumberBaseBall {
	private int my[] = new int[3];
	private int com[] = new int[3];

	BufferedReader in;
	private int ball = 0;
	private int strike = 0;
	private int checkCount = 0;

	public NumberBaseBall() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	private void comRandom() {
		// 0이면안된다.
		ball = 0;
		strike = 0;
		checkCount = 0;
		com[0] = (int) (Math.random() * 9) + 1;

		// 중복이면 안된다.
		while (true) {
			com[1] = (int) (Math.random() * 10);
			com[2] = (int) (Math.random() * 10);
			if (com[0] != com[1] && com[2] != com[0] && com[2] != com[1]) {
				break;
			}
		} // end while
	}

	private void game() throws NumberFormatException, IOException {
		for (int i = 0; i < com.length; i++) {
			if(i==2) {
				continue;
			}else {
				System.out.println(i);	
			}
		}
		// 컴퓨터 숫자 생성
		comRandom();
		while (true) {
			// 체크 횟수 증가
			checkCount++;
			// 숫자입력
			System.out.print("숫자입력: ");

			int myNum = getNumber(); // 149
			my[2] = myNum % 10;
			my[1] = (myNum / 10) % 10;
			my[0] = (myNum / 100) % 10;
			System.out.println(Arrays.toString(com));

			if (my[0] == my[1] || my[1] == my[2] || my[0] == my[2]) {
				continue;
			}
			
			// 숫자비교
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					// 같은 값 발견
					if (my[i] == com[j]) {
						// 스트라이크인가 ball인가?
						if (i != j) {
							ball++;
							break;
						} else {
							strike++;
							break;
						}
					} // end if
				} // end for
			} // end for
			System.out.println(Arrays.toString(my) + "는 " + strike + "스트라이크 " + ball + "볼입니다.");
			// 결과
			if (strike != 3) {
				strike = 0;
				ball = 0;
			} else {
				System.out.println(Arrays.toString(my) + "는" + checkCount + " 번째만에 정답입니다.");
				System.out.print("계속 (1) 종료 (0): ");
				int menu = -1;
				menu = Integer.parseInt(in.readLine());
				if (menu == 1) {
					comRandom();
				} else if (menu == 0) {
					System.out.println("종료되었습니다.");
					System.exit(0);
				}
			} // end strike condition
		} // end while

	}// end game

	private int getNumber() {
		int num = 0;
		try {
			num = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		NumberBaseBall nbb = new NumberBaseBall();
		nbb.game();

	}// end main

}
