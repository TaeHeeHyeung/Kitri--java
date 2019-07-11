package com.kitri.library.bookmng;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookMngController implements ActionListener {

	BookMngService bookMngService;
	private BookMng pBookMng;

	public BookMngController(BookMng pBookMng) {
		super();
		this.pBookMng = pBookMng;
		bookMngService = new BookMngService(pBookMng);
	}

	// -----------------------��������������--------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// �����߰���ư
		if (obj == pBookMng.btnAdd) {
			if(pBookMng.pMain == null) {
				System.out.println("BookMngController: ������ ���̴�.");
			}
			bookMngService.viewBookAdd();
		}
		// �����߰�������ư
		else if (obj == pBookMng.btnDelete) {
			bookMngService.pBookMngDeleteBook();
		}
		// ���� ��ư ->����ȭ������
		else if (obj == pBookMng.btnCancel) {
			bookMngService.pBookClose();
		}
		// ���� �˻� ��ư
		else if (obj == pBookMng.btnSearch) {
			String searchStr = pBookMng.tfSearch.getText().trim();
			String searchMethodStr = (String) pBookMng.comboBoxMenu.getSelectedItem();
			bookMngService.bookSearchBookMng(searchMethodStr, searchStr);
		}

		// ���� ��������
		else if (obj == pBookMng.btn_Update) {
			bookMngService.openBookInfo();
		} 
		
		
	}
}
