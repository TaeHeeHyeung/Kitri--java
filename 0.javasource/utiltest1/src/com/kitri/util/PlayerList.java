package com.kitri.util;

import java.util.*;

public class PlayerList {

	public static void main(String[] args) {
		List<PlayerDto> list = new ArrayList<PlayerDto>();
		list.add(new PlayerDto(24, "오재원", 4, 0.321));
		list.add(new PlayerDto(13, "허경민", 5, 0.351));
		list.add(new PlayerDto(34, "린드블럼", 1, 0.001));
		list.add(new PlayerDto(9, "페르난데스", 3, 0.421));
		list.add(new PlayerDto(38, "김대한", 7, 0.384));

		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.println(list.get(i));
		}

		int number = 38;
		boolean isExsist=false;
		PlayerDto playerDto = null;
		for (int i = 0; i < len; i++) {
			if (list.get(i).getNumber() == number) {
				playerDto= list.get(i);
				isExsist =true;
				break;
			}
		}
		if(playerDto != null) {
			System.out.println(number + " 번 선수 정보" + playerDto);	
		}else {
			System.out.println(number + "의 정보는 없습니다.");
		}
		

	}// end main
}// end class
