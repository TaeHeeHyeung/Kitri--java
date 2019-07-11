package com.kitri.awt.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcualtorControl implements ActionListener {
	Calculator calculator;
	CalculatorService calcuratorService;

	public CalcualtorControl(Calculator calculator) {
		super();
		this.calculator = calculator;
		calcuratorService = new CalculatorService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		for (int i = 0; i < calculator.btn.length; i++) {
			for (int j = 0; j < calculator.btn[i].length; j++) {
				if (calculator.btn[i][j] == obj) {
					String getStr = calculator.str[i][j];
					if (getStr.charAt(0) - 48 >= 0 && getStr.charAt(0) - 48 < 10) {
//						System.out.println("숫자입니다.");
						calcuratorService.appendNumL(getStr);
					} else {
//						System.out.println("문자입니다.");
						calcuratorService.appendOperL(getStr);
					}
				}
			}
		} // end for

		if (obj == calculator.exit) {
			calcuratorService.exit();
		}
	}// end actionPerformed

}// end CalcualtorControl class
