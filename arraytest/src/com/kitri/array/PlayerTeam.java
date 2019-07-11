package com.kitri.array;

public class PlayerTeam {
	public static void main(String[] args) {
		//1번 투수, 2 포수, 1루수, 2루수, 3루수, 유격수 , 외야수(좌익수, 중견수, 우익수)
		//1~9
		//지명타자 0
		//총 10명
		
		//타율, 방어율 
		//린드블럼은 방어율 (투수니까)
		
		PlayerDto[] player = new PlayerDto[5];
		player [0] = new PlayerDto(24, "오재원", 4, 0.321);
		player [1] = new PlayerDto(13, "허경민",5 , 0.351);
		player [2] = new PlayerDto(34, "린드블럼", 1, 0.001);
		player [3] = new PlayerDto(9, "페르난데스", 3, 0.421);
		player [4] = new PlayerDto(38, "김대한", 7, 0.384);
		
		int len = player.length;
		for(int i=0; i<len ; i++) {
		}
		//메모리 참조횟수가 length만큼 실행된다.
		for(int i=0; i<player.length; i++) {
		}
		
		//myfor ctrl + space 자동완성 만들기 
		//설정 window preference java editor template for 의 내용 저장 새로 만들기 myfor
		for (int i = 0; i < len; i++) {
			System.out.println(player[i]);
		}
		
	}
}
