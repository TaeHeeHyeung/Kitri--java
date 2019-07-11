package com.kitri.util.jcf;

import java.util.*;



public class CollectionTest {

	
	
	public static void main(String[] args) {

//		Collection coll = new ArrayList();  // 어레이리스트를 참조했기떄문에 순서대로 들어가있다.
		Collection coll = new HashSet();    // 해시셋이기떄문에 순서가 유지되지않는다. 
		System.out.println("초기 크기 : " + coll.size());
		coll.add("홍길동");
		coll.add("이순신");
		coll.add("강감찬");
		coll.add("윤봉길");
		coll.add("이순신"); //해쉬셋은 중복을 허용하지않는다.
//		coll.add(new Integer(10));
		System.out.println("마지막 크기 : " + coll.size()); // 크기가 유동적이다.
		
		Object ob[] = coll.toArray(); 
		
		int len = ob.length;
		for (int i = 0; i < len; i++) {
			System.out.println((String) ob[i]); //컬렉션의 단점. 얻어올떄마다 형변환해야함
		}
		
		
	}

}
