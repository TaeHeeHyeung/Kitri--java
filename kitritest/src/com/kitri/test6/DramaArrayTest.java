package com.kitri.test6;

public class DramaArrayTest {

	public static void main(String[] args) {
		TVProgram[] tvPrograms = new Drama[4];
		tvPrograms[0] = new Drama("그 겨울,","SBS", "김규태", "조인성", "송혜교");
		tvPrograms[1] = new Drama("백년의 유산,","MBC", "조성우", "", "");
		tvPrograms[2] = new Drama("아이리스2,","KBS", "표민수", "장혁", "이다혜");
		tvPrograms[3] = new Drama("최고다 이순신,","KBS", "윤성식", "", "아이유");
		int len = tvPrograms.length;
		for (int i = 0; i < len; i++) {
			System.out.println(i+1+". "+tvPrograms[i].toString());
		}
		
	}

	
}
