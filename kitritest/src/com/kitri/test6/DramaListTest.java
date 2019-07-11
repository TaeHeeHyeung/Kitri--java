package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {

	public static void main(String[] args) {
		List<Drama> listDrama= new ArrayList<Drama>();
		
		listDrama.add(new Drama("그 겨울,","SBS", "김규태", "조인성", "송혜교"));
		listDrama.add(new Drama("백년의 유산,","MBC", "조성우", "", ""));
		listDrama.add(new Drama("아이리스2,","KBS", "표민수", "장혁", "이다혜"));
		listDrama.add(new Drama("최고다 이순신,","KBS", "윤성식", "", "아이유"));
		
		int len = listDrama.size();
		for (int i = 0; i < len; i++) {
			System.out.println(i+1+". "+listDrama.get(i).toString());
		}
	}//end main
}
