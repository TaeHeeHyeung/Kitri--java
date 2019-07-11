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

	// -----------------------도서관리페이지--------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// 도서추가버튼
		if (obj == pBookMng.btnAdd) {
			if(pBookMng.pMain == null) {
				System.out.println("BookMngController: 메인이 널이다.");
			}
			bookMngService.viewBookAdd();
		}
		// 도서추가삭제버튼
		else if (obj == pBookMng.btnDelete) {
			bookMngService.pBookMngDeleteBook();
		}
		// 종료 버튼 ->메인화면으로
		else if (obj == pBookMng.btnCancel) {
			bookMngService.pBookClose();
		}
		// 도서 검색 버튼
		else if (obj == pBookMng.btnSearch) {
			String searchStr = pBookMng.tfSearch.getText().trim();
			String searchMethodStr = (String) pBookMng.comboBoxMenu.getSelectedItem();
			bookMngService.bookSearchBookMng(searchMethodStr, searchStr);
		}

		// 도서 정보수정
		else if (obj == pBookMng.btn_Update) {
			bookMngService.openBookInfo();
		} 
		
		
	}
}
