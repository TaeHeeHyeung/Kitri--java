package com.kitri.util;

import java.util.*;

public class PlayerList {

	List<PlayerDto> list = new ArrayList<PlayerDto>();

	private List<PlayerDto> getList() {
		return list;
	}

	private void playerRegister(PlayerDto playerDto) {
		list.add(playerDto);
	}
	
	private PlayerDto playerSearch(int number) {
		PlayerDto playerDto = null;
		int len = list.size();
		for (int i = 0; i < len; i++) {
			if (list.get(i).getNumber() == number) {
				playerDto = list.get(i);
				break;
			}
		}
		return playerDto;
	}// end search

	private void playerList() {
		System.out.println("=== 두산 베어스 팀명단");
		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.println(list.get(i));
		}
	}

	private void playerInfo(PlayerDto playerDto) {
		if (playerDto != null) {
			System.out.println(playerDto.getNumber() + " 번 선수 정보" + playerDto);
		} else {
			System.out.println(" 정보는 없습니다.");
		}
	}

	public static void main(String[] args) {
		PlayerList pl = new PlayerList();
		pl.playerRegister(new PlayerDto(24, "오재원", 4, 0.321));
		pl.playerRegister(new PlayerDto(13, "허경민", 5, 0.351));
		pl.playerRegister(new PlayerDto(34, "린드블럼", 1, 0.001));
		pl.playerRegister(new PlayerDto(9, "페르난데스", 3, 0.421));
		pl.playerRegister(new PlayerDto(38, "김대한", 7, 0.384));

		pl.playerList();
		
		int number = 13;
		PlayerDto playerDto = pl.playerSearch(number);
		pl.playerInfo(playerDto);
		
		number= 38;
		double score =0.357;
		playerDto = pl.playerSearch(number);
		playerDto.setGrade(score);
		System.out.println(number +"번 선수가 안타!!! 타율이 "+score+"로 변경");
		
		
		pl.playerInfo(playerDto);
		// 타율을 3할 5푼 7리로 변경
		String str = Double.toString(score);
		int len = str.length();
		int num1 = str.charAt(2) - 48;
		System.out.print("타율: "+ num1 + "할 ");
		int num2 = str.charAt(3) - 48;
		System.out.print(num2 + "푼 ");
		int num3 = str.charAt(4) - 48;
		System.out.print(num2 + "리");

	}// end main


}// end class
