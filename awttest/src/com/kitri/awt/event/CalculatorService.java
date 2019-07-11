package com.kitri.awt.event;

public class CalculatorService {
	CalcualtorControl calcualtorControl;
	Calculator cal;

	private double num1 = 0;

	public CalculatorService(CalcualtorControl calcualtorControl) {
		this.calcualtorControl = calcualtorControl;
		cal = this.calcualtorControl.calculator;
	}// end CalculatorService

	public void appendNumL(String numStr) {

		// 소수점 검사
		double f = Double.parseDouble(getNumL()) - (int) (Double.parseDouble(getNumL()));
		if (getNumL().equals("0") || getNumL().equals("")) {
			setNumL(numStr);
		} // 소수점이면서 번호룰 눌렀을 때
		else if (f > 0 || f < 0) {
			setNumL(numStr);
		} else {
			setNumL(getNumL() + numStr);
		}

	}// appendNumL

	public void appendOperL(String operStr) {

		if (operStr.equals("C")) {
			num1 = 0;
			setNumL("0");
			setOperL("");
			return;
		}
		if (operStr.equals("=")) {
			if (getOperL().equals("+")) {
				double result = num1 + Double.parseDouble(getNumL());
				num1 = result;
				setNumL(String.valueOf(result));
			} else if (getOperL().equals("-")) {
				double result = num1 - Double.parseDouble(getNumL());
				num1 = result;
				setNumL(String.valueOf(result));
			} else if (getOperL().equals("*")) {
				double result = num1 * Double.parseDouble(getNumL());
				num1 = result;
				setNumL(String.valueOf(result));
			} else if (getOperL().equals("/")) {
				double result = num1 / Double.parseDouble(getNumL());
				num1 = result;
				setNumL(String.valueOf(result));
			}
			setOperL("");
		} else if (getOperL().equals("")) {
			setOperL(operStr);
			num1 = Double.parseDouble(getNumL());
			setNumL("0");
		} else if (!getOperL().equals(operStr)) {
			setOperL(operStr);
			setNumL("0");
		}

	}// appendOperL

	public void exit() {
		System.exit(0);
	}

	private String getOperL() {
		return cal.operL.getText();
	}

	private String getNumL() {
		return cal.numL.getText();
	}

	private void setOperL(String str) {
		cal.operL.setText(str);
	}

	private void setNumL(String str) {
		cal.numL.setText(str);
	}
}// end CalculatorService class
