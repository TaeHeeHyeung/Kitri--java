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
		// -----------------------도서상세정보--------------------------
		// 도서 상세 화면 닫기
		if (obj == pBookInfo.btn_close) {
			bookInfoService.close();
		}
		// 도서 변경 완료
		else if (obj == pBookInfo.btn_editConfirm) {
			bookInfoService.bookEditConfirm();
		}
		// 도서 상세정보 수정하기
		else if (obj == pBookInfo.btn_edit) {
			bookInfoService.editBookProcess();
		}
		//도서 이미지 변경하기
		else if (obj == pBookInfo.bt_img) {
			bookInfoService.readImage();
		}
	}

}
