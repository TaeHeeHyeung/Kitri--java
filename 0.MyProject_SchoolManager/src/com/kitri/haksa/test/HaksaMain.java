package com.kitri.haksa.test;

import java.io.*;

import com.kitri.haksa.data.HaksaDto;
import com.kitri.haksa.service.HaksaServiceImpl;

public class HaksaMain {
	// delete pdf�� ���� ���� �߰�
	// ������ �����Ǿ����ϴ�.
	// ������ �������� �ʽ��ϴ�.
	// delete return type => void�� �ٲ㵵 ������.
	public static void main(String[] args) throws IOException {
		HaksaServiceImpl haksaServiceImpl = new HaksaServiceImpl();
		haksaServiceImpl.menu();

	}// end main

}// end Main class
