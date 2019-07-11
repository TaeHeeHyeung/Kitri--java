package com.kitri.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberFormatTest {

	public static void main(String[] args) {
		double number = 12345365453.1267843;
		
		double numb = 0.1267;
		System.out.println(numb);
		NumberFormat nf= new DecimalFormat("###,###,###,###,##.#######");
		String str = nf.format(number);
		System.out.println(str);
		
		
		
	}
}
