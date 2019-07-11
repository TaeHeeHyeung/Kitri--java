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
		System.out.println("=== �λ� ��� �����");
		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.println(list.get(i));
		}
	}

	private void playerInfo(PlayerDto playerDto) {
		if (playerDto != null) {
			System.out.println(playerDto.getNumber() + " �� ���� ����" + playerDto);
		} else {
			System.out.println(" ������ �����ϴ�.");
		}
	}

	public static void main(String[] args) {
		PlayerList pl = new PlayerList();
		pl.playerRegister(new PlayerDto(24, "�����", 4, 0.321));
		pl.playerRegister(new PlayerDto(13, "����", 5, 0.351));
		pl.playerRegister(new PlayerDto(34, "�����", 1, 0.001));
		pl.playerRegister(new PlayerDto(9, "�丣������", 3, 0.421));
		pl.playerRegister(new PlayerDto(38, "�����", 7, 0.384));

		pl.playerList();
		
		int number = 13;
		PlayerDto playerDto = pl.playerSearch(number);
		pl.playerInfo(playerDto);
		
		number= 38;
		double score =0.357;
		playerDto = pl.playerSearch(number);
		playerDto.setGrade(score);
		System.out.println(number +"�� ������ ��Ÿ!!! Ÿ���� "+score+"�� ����");
		
		
		pl.playerInfo(playerDto);
		// Ÿ���� 3�� 5Ǭ 7���� ����
		String str = Double.toString(score);
		int len = str.length();
		int num1 = str.charAt(2) - 48;
		System.out.print("Ÿ��: "+ num1 + "�� ");
		int num2 = str.charAt(3) - 48;
		System.out.print(num2 + "Ǭ ");
		int num3 = str.charAt(4) - 48;
		System.out.print(num2 + "��");

	}// end main


}// end class
