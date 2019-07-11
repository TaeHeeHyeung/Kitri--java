package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

//0. com, my 3�ڸ� �迭.
//1. com, my, �� �ڸ� ���� �߻� >>comRandom()
//2. 1�� ���ڴ� �ߺ� ���� X
//				0���� ����X
//3. ���� �Է��� 3�ڸ� ���ڸ� my �迭�� �ֱ�
//4. com�� my�� ���ڿ� �ڸ���
//5. ���ڰ� ���ٸ�
// 	5-1 �ڸ����� ���ٸ� strike ����
//	5-2	�ڸ����� �ٸ��ٸ� ball ����
//6. 
//	6-1 5�� ��� strike�� 3 : 
// 		xxx�� x��°���� �����Դϴ�. 
// 		���(1), ����(0)
// 	6-2 strike�� 3�� �ƴ϶��
//		1. xxx�� x��Ʈ����ũ x���Դϴ�. >> 3������

// ���� Ǭ��
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
		// 0�̸�ȵȴ�.
		ball = 0;
		strike = 0;
		checkCount = 0;
		com[0] = (int) (Math.random() * 9) + 1;

		// �ߺ��̸� �ȵȴ�.
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
		// ��ǻ�� ���� ����
		comRandom();
		while (true) {
			// üũ Ƚ�� ����
			checkCount++;
			// �����Է�
			System.out.print("�����Է�: ");

			int myNum = getNumber(); // 149
			my[2] = myNum % 10;
			my[1] = (myNum / 10) % 10;
			my[0] = (myNum / 100) % 10;
			System.out.println(Arrays.toString(com));

			if (my[0] == my[1] || my[1] == my[2] || my[0] == my[2]) {
				continue;
			}
			
			// ���ں�
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					// ���� �� �߰�
					if (my[i] == com[j]) {
						// ��Ʈ����ũ�ΰ� ball�ΰ�?
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
			System.out.println(Arrays.toString(my) + "�� " + strike + "��Ʈ����ũ " + ball + "���Դϴ�.");
			// ���
			if (strike != 3) {
				strike = 0;
				ball = 0;
			} else {
				System.out.println(Arrays.toString(my) + "��" + checkCount + " ��°���� �����Դϴ�.");
				System.out.print("��� (1) ���� (0): ");
				int menu = -1;
				menu = Integer.parseInt(in.readLine());
				if (menu == 1) {
					comRandom();
				} else if (menu == 0) {
					System.out.println("����Ǿ����ϴ�.");
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
