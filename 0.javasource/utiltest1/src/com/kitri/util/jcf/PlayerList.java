package com.kitri.util.jcf;

import java.util.*;

public class PlayerList {
//	List<PlayerDto> list = new ArrayList<PlayerDto>();
//Note that this implementation is not synchronized.
//어레이리스트는 완벽한 순서를 보장할 수 없다.그렇기에 속도가 빠름.
//완벽하게 0.000001%데이터의 일치를 원하면 벡터를 그외엔 전부다 어레이리스트다.
	List<PlayerDto> list = new Vector<PlayerDto>(); // 어레이 리스트를 하나 벡터를 하나 결과는 똑같다.
// 굳이 결과값이 똑같은 걸 구분해서 사용할 필요가 있을까?
//Vector is synchronized. 벡터는 동기화가 되어있다. 먼저 호출된 것을 호출하고 다음 -> 다음 순서대로 간다는 소리.벡터는 완벽한 순서가 보장됨.
//If a thread-safe implementation is not needed, it is recommended to use ArrayList in place of Vector.
	private void playeRegister(PlayerDto playerDto) {
		list.add(playerDto);
	}

	private void PlayerList() {
		System.out.println("=== 두산 베어스 팀명단 ===");
		System.out.println("----------------------------");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}

	}

	private PlayerDto playerSearch(int number) {
		PlayerDto playerDto = null;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			PlayerDto dto = list.get(i);
			if (number == dto.getNumber()) {
				playerDto = dto;
				break;
			}
		}

		return playerDto;
	}

	private void playerInfo(PlayerDto playerDto) {
		if (playerDto != null)
			System.out.println(playerDto);
		else
			System.out.println("번 선수는 없습니다.");
	}

	public static void main(String[] args) {
		PlayerList pl = new PlayerList();

		pl.playeRegister(new PlayerDto(24, "오재원", 4, 0.321));
		pl.playeRegister(new PlayerDto(13, "허경민", 5, 0.351));
		pl.playeRegister(new PlayerDto(34, "린드블럼", 1, 0.001));
		pl.playeRegister(new PlayerDto(9, "페르난데스", 3, 0.421));
		pl.playeRegister(new PlayerDto(38, "김대한", 7, 0.384));

		pl.PlayerList();

		int number = 38;
		System.out.println(number + "번 선수 정보!!");
		PlayerDto playerDto = pl.playerSearch(number);
		pl.playerInfo(playerDto);

		number = 13;
		double score = 0.357;
		pl.playerSearch(13);

		System.out.println(number + "번 선수가 안타!!!! 타율이 " + score + "로 변경");
		playerDto = pl.playerSearch(number);
		playerDto.setGrade(score);
		pl.playerInfo(playerDto);

		pl.PlayerList();// 리스트 안에 들어있는건 레퍼런스가 저장되는거지 객체가 카피되는 것이 아니다.

	}

}
