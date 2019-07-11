package com.kitri.library.controller;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.kitri.library.bookmng.bookinfo.BookInfo;
import com.kitri.library.db.*;
import com.kitri.library.main.start.StartTest;

public class Service {
	Controller controller;
	StartTest uiManager;
	private MenagerDao menagerDao = new MenagerDao();

	public Service(StartTest mUiManager) {
		super();
		this.uiManager = mUiManager;
	}
	// 도서정보 변경 막기

	// 테이블 갱신
	private void updateTable() {
//		uiManager.pBookMng.tableModelUpdate();
//		uiManager.pMain.tableModelUpdate();
	}
}
