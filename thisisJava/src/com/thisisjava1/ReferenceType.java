package com.thisisjava1;

public class ReferenceType {

	public static void main(String[] args) {
		problum6();
		problum7();
		problum8();
		problum9();
	}// end main

	static void problum6() {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		System.out.println(array.length);
		System.out.println(array[2].length);
	}

	static void problum7() {
		int max = 0;
		int[] array = { 1, 5, 3, 8, 2 };
		max = array[0];
		for (int i = 1; i < 5; i++) {
			max = Math.max(max, array[i]);
		}
		System.out.println("max:"+max);
	}

	static void problum8() {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88},
		};
		
		int sum = 0;
		int count =0;
		double avg = 0.0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
				count++;
			}
		}
		
		System.out.println(sum);
		System.out.println((double)sum/count);		
	}//problum8

	static void problum9() {
		boolean run = true;
		int studentNum =0;
		int[] scores = null;
		
	}
}
