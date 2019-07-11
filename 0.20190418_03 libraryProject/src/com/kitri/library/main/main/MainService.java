package com.kitri.library.main.main;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.kitri.library.bookmng.BookMng;
import com.kitri.library.db.BookDto;
import com.kitri.library.main.login.Login;
import com.kitri.library.main.start.StartTest;

public class MainService {

	MainController mainController;
	MainTest mainTest;

	public MainService(MainController controller) {
		super();
		mainController = controller;
		this.mainTest = mainController.mainTest;
	}

	// �������� ����
	public void openBookMng() {
		mainTest.pBookMng.setVisible(true);
	}// end openBookMng()

	// ���� �뿩 ����
	public void openRent() {
		mainTest.rent.setVisible(true);
	}

	// ���� �ݳ�
	public void openReturn() {
		mainTest.pReturn.setVisible(true);
	}

	// ���� ����
	public void openMemMng() {
		mainTest.pMemberMng.setVisible(true);
	}

	// �����˻� (main)
	public void searchBookPMain(String searchMethodStr, String searchStr) {
		mainTest.bookDao.setAllList();
		
		
		Vector<BookDto> list = mainTest.bookDao.getList(searchMethodStr, searchStr);
		mainTest.setTableModel(list);
//		// ���� �߰��� ������
//		Vector<Vector<String>> vecList = new Vector<Vector<String>>();
//		int len = list.size();
//		for (int i = 0; i < len; i++) {
//			Vector<String> vec = new Vector<String>();
//			vec.add(list.get(i).getName());
//			vec.add(list.get(i).getWriter());
//			vec.add(list.get(i).getIsbn());
//			vec.add(list.get(i).getPosition());
//			vec.add(list.get(i).getPublish_dateStr());
//			vec.add(list.get(i).getPublisher());
//			vecList.add(vec);
//		}
//		Vector<String> colVec = new Vector<String>();
//		len = mainTest.colArr.length;
//		for (int i = 0; i < len; i++) {
//			colVec.add(mainTest.colArr[i]);
//		}
//		// �����Ϸ��� model�� �߰��ؾ��Ѵ�.
//		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
//		mainTest.main_table.setModel(model);
	}// end searchBook

	public void logOut() {
		System.out.println("logOut service");
		mainTest.startTest.cardLayout.show(mainTest.startTest.panel_cardLayout, StartTest.CARD_STR_PLOGIN);
		mainTest.setVisible(false);
		mainTest.startTest.pLogin.setVisible(true);
		mainTest.startTest.pLogin.initTF();
	}

	public void viewStatistic() {
//		mainTest.statisticTest.setVisible(true);
	}
}
