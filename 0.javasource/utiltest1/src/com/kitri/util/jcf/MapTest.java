package com.kitri.util.jcf;

import java.util.*;

public class MapTest {
	
	public static void main(String[] args) {
//		Map<String, PlayerDto> map = new HashMap<String, PlayerDto>();
//사실상 동기화문제는 프로그램단에서 해결할 문제이기떄문에 속도가 빠른 HashMap을 사용한다.
		Map<String, PlayerDto> map = new Hashtable<String, PlayerDto>();
//키값이 같다라는 가정하에선 덮어씌워버리기떄문에 해시테이블을 사용하기도한다.
		map.put("DS24",new PlayerDto(24, "오재원", 4, 0.321));
		map.put("DS9",new PlayerDto(9, "페르난데스", 3, 0.421));
		map.put("KW24",new PlayerDto(24, "박병호", 3, 0.431)); // 똑같은 키 값을 가지고오게되면 덮어씌우기떄문에
		map.put("HH19",new PlayerDto(19, "정근우", 7, 0.321)); // 키 이름을 다르게 해서 저장하면됨.
		
		int size = map.size();
		System.out.println("등록 인원  : "+ size); // 맵도 똑같이 4명이된다.
		
		int number = 24; 
		System.out.println("두산의 "+number+"번의 정보!!");
		PlayerDto playerDto = map.get("DS"+number);//결과적으로 맵을 사용하려면 키값을 기억해야한다.
		System.out.println(playerDto);
//		playerDto = map.values(); // 리턴값이 컬렉션인 이유는 맵안에 순서가 없기떄문이다.
//		밸류스는 값을 얻어올수 있다. // 맵 안에 들어있는건 레퍼런스가 저장되는거지 객체가 카피되는 것이 아니다.
		
	}

}
