package com.kitri.calculator;

import java.awt.*;

public class Calculator extends Frame {
	String[][] str = { { "7", "8", "9", "+" }, { "4", "5", "6", "-" }, { "1", "2", "3", "*" }, { "0", "C", "=", "/" } };
	Button[][] btn = new Button[4][4];

	Panel pN = new Panel(new BorderLayout(10, 0));
	Panel pS = new Panel(new BorderLayout());
	Panel pC = new Panel(new GridLayout(4, 4, 10, 10));

	Label numL = new Label("0"); // 숫자만
	Label operL = new Label("", Label.CENTER); // 연산자만 (마지막 꺼만)
//	Label numL = new Label("", Label.CENTER); // 숫자만 가운대 정렬
//	Label operL = new Label("", Label.CENTER); // 연산자만 (마지막 꺼만) 가
	Button exit = new Button("종료");

	Font font = new Font("고딕", Font.BOLD, 20);

	public Calculator() {

		setLayout(new BorderLayout(0, 10));

		numL.setBackground(new Color(150, 0, 150));
		operL.setBackground(new Color(150, 0, 150));
		numL.setFont(font);
		operL.setFont(font);

		pN.add(numL, BorderLayout.CENTER);
		pN.add(operL, BorderLayout.EAST);
		add(pN, BorderLayout.NORTH);

		//그라데이션 색상 조절
		int minColorValue = 77;
		if (minColorValue > 255) {
			minColorValue = 255;
		}
		int color = (255 - minColorValue) / (str.length * 2 - 1) - 10;
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				btn[i][j] = new Button(str[i][j]);
				btn[i][j].setFont(font);
				pC.add(btn[i][j]);
				btn[i][j].setBackground(
						new Color((int) (color * (i + j) + minColorValue), 0, (int) (color * (i + j) + minColorValue)));
			}
		} // end for

		add(pC, BorderLayout.CENTER);
		pS.add(exit, BorderLayout.CENTER);
		add(pS, BorderLayout.SOUTH);

		setBounds(480, 500, 400, 400);
		setVisible(true);

		// 리스너 등록
		CalcualtorControl calcualtorControl = new CalcualtorControl(this);
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				btn[i][j].addActionListener(calcualtorControl);
			}
		} // end for
		exit.addActionListener(calcualtorControl);

	}// end Calculator

	public static void main(String[] args) {
		new Calculator();
	}// end main

}// end Calculator class
