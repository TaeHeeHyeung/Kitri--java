package com.kitri.haksa.test;

import java.io.*;

import com.kitri.haksa.data.HaksaDto;
import com.kitri.haksa.service.HaksaServiceImpl;

public class HaksaMain {
	// delete pdf에 없는 내용 추가
	// 있으면 삭제되었습니다.
	// 없으면 존재하지 않습니다.
	// delete return type => void로 바꿔도 괜찮다.
	public static void main(String[] args) throws IOException {
		HaksaServiceImpl haksaServiceImpl = new HaksaServiceImpl();
		haksaServiceImpl.menu();

	}// end main

}// end Main class
