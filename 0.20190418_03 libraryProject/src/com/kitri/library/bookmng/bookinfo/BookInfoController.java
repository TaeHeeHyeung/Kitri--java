package com.kitri.library.bookmng.bookinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.library.bookmng.BookMng;
import com.kitri.library.main.main.MainTest;

public class BookInfoController implements ActionListener {

	public BookInfo pBookInfo;
	BookInfoService bookInfoService;
	public BookMng pBookMng;
	public MainTest pMainTest;

	public BookInfoController(BookInfo bookInfo) {
		this.pBookInfo = bookInfo;
		pMainTest = bookInfo.pMainTest;
		pBookMng = bookInfo.pBookMng;

		bookInfoService = new BookInfoService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// -----------------------����������--------------------------
		// ���� �� ȭ�� �ݱ�
		if (obj == pBookInfo.btn_close) {
			bookInfoService.close();
		}
		// ���� ���� �Ϸ�
		else if (obj == pBookInfo.btn_editConfirm) {
			bookInfoService.bookEditConfirm();
		}
		// ���� ������ �����ϱ�
		else if (obj == pBookInfo.btn_edit) {
			bookInfoService.editBookProcess();
		}
		//���� �̹��� �����ϱ�
		else if (obj == pBookInfo.bt_img) {
			bookInfoService.readImage();
		}
	}

}
