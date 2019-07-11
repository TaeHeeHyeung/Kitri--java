package com.kitri.library.main.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.library.main.login.Login;

public class MainController implements ActionListener {

	MainService service;
	public MainTest mainTest;

	public MainController(MainTest pMain) {
		super();
		this.mainTest = pMain;
		service = new MainService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == mainTest.btn_pBookmang) { // ��������
			service.openBookMng();
		} else if (obj == mainTest.btn_pRent) {// �뿩
			service.openRent();
		} // end loginBt
		else if (obj == mainTest.btn_pBookRet) { // �ݳ�
			service.openReturn();
		} else if (obj == mainTest.btn_pMembers) { // ȸ������
			service.openMemMng();
		} else if (obj == mainTest.btn_bookSearch) {// ���� �˻�
			String searchStr = mainTest.tf_searchBook.getText().trim();
			String searchMethodStr = (String) mainTest.comboSerarchBookMenu.getSelectedItem();
			service.searchBookPMain(searchMethodStr, searchStr);
		} else if (obj == mainTest.btn_pLogOut) {// �α׾ƿ�
			service.logOut();
		} 
//		else if (obj == mainTest.btn_pStatis) {
//			service.viewStatistic();
//		}
	}

}
