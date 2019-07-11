package com.kitri.util;

import java.util.*;

public class Lotto {

	public static void main(String[] args) {
		Random random = new Random();

		Set<Integer> ranNumSet = new HashSet<Integer>();
		while (ranNumSet.size() < 6) {
			ranNumSet.add(random.nextInt(45) + 1);
		}

		Integer[] arr = ranNumSet.toArray(new Integer[0]);
		System.out.println(Arrays.toString(arr));

		
	}

}
