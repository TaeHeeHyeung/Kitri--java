package com.kitri.library.ret;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.kitri.library.db.BookDto;

public class BookRetService {

	BookRetController bookRetController;
	BookReturn bookReturn;

	public BookRetService(BookRetController bookReturnController) {
		this.bookRetController = bookReturnController;
		bookReturn = bookReturnController.bookReturn;
	}

	// 반납리스트 추가
	public void addRet() {
		String tfISBN = bookReturn.tf_isbn.getText();
		BookDto bookDto = bookReturn.bookDao.select(tfISBN);

		if (bookDto == null) {
			JOptionPane.showMessageDialog(bookReturn, "해당 도서가 존재하지 않습니다.");
			return;
		}else if(bookDto.getRenting().equals("no")) {
			JOptionPane.showMessageDialog(bookReturn, "이미 반납 처리된 책입니다.");
			
			return;
		}
		int len = bookReturn.contentsVec.size();
		for (int i = 0; i < len; i++) {
			Vector<String> contents = bookReturn.contentsVec.get(i);
			if (tfISBN.equals(contents.get(2))) {
				JOptionPane.showMessageDialog(bookReturn, "이미 반납 리스트에 포함되어있습니다.");
				return;
			}
		}
		// "도서명", "저자", "ISBN", "청구기호", "대여일", "반납자"
		bookReturn.contentsVec.add(new Vector<String>(
				Arrays.asList(new String[] { bookDto.getName(), bookDto.getWriter(), bookDto.getIsbn(),
						bookDto.getPosition(), bookDto.getPublish_dateStr(), bookDto.getRenting() })));

		DefaultTableModel model = new DefaultTableModel(bookReturn.contentsVec, bookReturn.HEADER_LIST);
		bookReturn.table.setModel(model);

	}// end addTable

	public void close() {
		bookReturn.tfInit();
		bookReturn.tableInit();
		bookReturn.dispose();
	}

	//반납하기
	public void retConfirm() {
		int len = bookReturn.contentsVec.size();
		for (int i = 0; i < len; i++) {
			Vector<String> contents = bookReturn.contentsVec.get(i);
			String isbn = contents.get(2);
			BookDto bookDto = bookReturn.bookDao.select(isbn);
			bookDto.setRenting("no");
			bookReturn.bookDao.upDateBook(isbn, bookDto);
		}
		bookReturn.tableInit();
		JOptionPane.showMessageDialog(bookReturn, "반납이 완료되었습니다.");
		bookReturn.mainTest.tableUpdate();
	}
}// end BookRetService class
