package com.kitri.exceiption.runtime;

public class NumberFormatTest {

	public static void main(String[] args) {
		String s = "123";

//		try {
//			int x = Integer.parseInt(s);
//			System.out.println(x + 100);
//		} catch (NumberFormatException e) {
//			System.out.println("¼ıX");
//		}
		if (isNumber(s)) {
			int x = Integer.parseInt(s);
			System.out.println(x + 100);
		} else {
			System.out.println("¼ıX");
		}
		
	}// end main

	private static boolean isNumber(String str) {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			int num = str.charAt(i) - 48;
			if (num < 0 || num > 9) {
				return false;
			}
		} // end for
		return true;
	}// end isNumber
	
}//end class
