package com.kitri.lang;

//Wrapper Class: 기본데이터 타입을 클래스화 
//기본데이터타입 	WrapperClass
//boolean		Boolean 
//char			Character
//byte			Byte
//short			Short
//int			Integer
//long			Long
//float			Float
//double		Double

public class WrapperClassTest {

	public static void main(String[] args) {
		Boolean b1 = new Boolean(true);
//		Boolean b1 = new Boolean("true");
		Boolean b2 = b1.booleanValue();
		
//		boolean b3 =Boolean.getBoolean("true"); => false
		boolean b3 =Boolean.parseBoolean("true");
		
		Integer integer= new Integer("123");
		int i = integer.intValue();
		
		i= Integer.parseInt("123")+4;
		
		String s = "123.45";
		double d = Double.parseDouble(s);
		System.out.println(d + 4);
		
//		System.out.println(i);
		
		//autoBoxing
		Integer i2= new Integer(3);
		//unBoxing
		int y =i2;
		//Boxing
		i2 = y;
	}

}
