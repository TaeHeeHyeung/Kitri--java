package com.kitri.array;

public class ArrayTest1 {

	public static void main(String[] args) {
		int x1 = 10;
		int x2 = 20;
		int x3 = 30;
		System.out.println("x1 = "+x1+ "\tx2 = "+ x2 + "\tx3 = "+ x3);

		int[] x;
		x= new int[3];
		for(int i=0; i<x.length; i++) {
			x[i]= (i+1)*10;
			System.out.println(x[i]);
		}
		
	}

}
