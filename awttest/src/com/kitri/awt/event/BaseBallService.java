package com.kitri.awt.event;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

public class BaseBallService {

	private int my[];
	private int com[];
	int gameLength;
	int count;

	BaseBallController baseBallController;
	private BaseBall bb;
	private FontColorChooser fcc;
	Random random = new Random();

	int r;
	int g;
	int b;
	
	public BaseBallService(BaseBallController baseBallController) {
		this.baseBallController = baseBallController;
		bb = baseBallController.baseBall;
		this.fcc = bb.fontColorChooser;
		gameLength = 3;
		my = new int[gameLength];
		com = new int[gameLength];
		newGame();
	}

	public void newGame() {
		count = 0;
		bb.ta.setEnabled(true);
		
		com[0] = random.nextInt(9) + 1;
		do {
			com[1] = random.nextInt(10);
		} while (com[0] == com[1]);
		do {
			com[2] = random.nextInt(10);
		} while (com[0] == com[2] || com[1] == com[2]);
		System.out.println("���� : " + com[0] + com[1] + com[2]);
		clear();
	}

	public void game() {

		int strike = 0;
		int ball = 0;

		String myNumStr = bb.tf.getText().trim();
		bb.tf.setText(" ");

		if (myNumStr.length() != gameLength || !isNumber(myNumStr)) {
			viewResult(gameLength + "�ڸ� ���ڸ� �Է��ϼ���.");
			return;
		}
		for (int i = 0; i < gameLength; i++) {
			my[i] = myNumStr.charAt(i) - 48;
		}

		for (int m = 0; m < gameLength; m++) {
			for (int c = 0; c < gameLength; c++) {
				if (my[m] == com[c]) { // ���� ���ڶ��..
					if (m == c)// �ڸ��� ���ٸ�...
						strike++;
					else
						ball++;
				}
			}
		}
		count++;

		if (strike != gameLength) {
			viewResult(count + "." + Arrays.toString(my) + "�� " + strike + "��Ʈ����ũ " + ball + "���Դϴ�.");
		} else {
			viewResult(Arrays.toString(my) + "�� " + count + "������ �����Դϴ�.");
			viewResult("�� ���� �Ǵ� ���Ḧ ��������!!");
			bb.ta.setEnabled(false);
		}

	}// end game

	private boolean isNumber(String str) {
		for (int i = 0; i < gameLength; i++) {
			int num = str.charAt(i) - 48;
			if (num < 0 || num > 9) {
				return false;
			}
		} // end for
		return true;
	}//end isNumber

	private void viewResult(String msg) {
		bb.ta.append(msg + "\n");
	}

	public void exit() {
		System.exit(0);
	}

	public void fontColorChange() {
		fcc.setVisible(true);
		changeColor();
	}

	public void showDap() {
		bb.ta.append("������ " + Arrays.toString(com) + " �Դϴ�.\n");
		viewResult("�� ���� �Ǵ� ���Ḧ ��������!!");
		bb.ta.setEnabled(false);
	}

	public void clear() {
		bb.ta.setText(" ");
	}

	public void changeColor() {
		r = fcc.sbR.getValue();
		g = fcc.sbG.getValue();
		b = fcc.sbB.getValue();
		fcc.colorP.setBackground(new Color(r, g, b));
		fcc.colorL.setText("r= " + r + "g= " + g + "b=" + b);
	}

	public void selectColor() {
		bb.ta.setForeground(new Color(r, g, b));
		
		fcc.setVisible(false);
	}
	
}
