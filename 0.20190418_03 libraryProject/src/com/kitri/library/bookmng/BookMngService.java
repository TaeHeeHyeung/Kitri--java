package com.kitri.library.bookmng;

import java.sql.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.kitri.library.db.BookDto;
import com.kitri.library.file.ImageFile;

public class BookMngService {

	private BookMng bookMng;

	public BookMngService(BookMng pBookMng) {
		this.bookMng = pBookMng;
	}

	public void pBookClose() {
		bookMng.dispose();
	}

	// 도서 추가 열기.
	public void viewBookAdd() {
		bookMng.pBookAdd.setVisible(true);
	}// end viewBookAdd()

	// 도서 검색
	public void bookSearchBookMng(String searchMethodStr, String searchStr) {
		Vector<BookDto> list = bookMng.bookDao.getList(searchMethodStr, searchStr);
		// 새로 추가할 데이터
		Vector<Vector<String>> vecList = new Vector<Vector<String>>();
		int len = list.size();
		for (int i = 0; i < len; i++) {
			Vector<String> vec = new Vector<String>();
			vec.add(list.get(i).getName());
			vec.add(list.get(i).getWriter());
			vec.add(list.get(i).getIsbn());
			vec.add(list.get(i).getPosition());
			vec.add(list.get(i).getPublish_dateStr());
			vec.add(list.get(i).getPublisher());
			vecList.add(vec);
		}
		Vector<String> colVec = new Vector<String>();
		len = bookMng.COL_TABLE_ARR.length;
		for (int i = 0; i < len; i++) {
			colVec.add(bookMng.COL_TABLE_ARR[i]);
		}
		// 갱신하려면 model을 추가해야한다.
		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
		bookMng.book_table.setModel(model);
	}

	// 도서관리자 도서정보 삭제
	public void pBookMngDeleteBook() {
		// 테이블 선택된 값 리턴
		int row = bookMng.book_table.getSelectedRow();
		if (row != -1) {
			String isbn = (String) bookMng.book_table.getValueAt(row, 2);
			BookDto bDto = bookMng.bookDao.select(isbn);
			if(!bDto.getRenting().equals("no")) {
				JOptionPane.showMessageDialog(bookMng, bDto.getRenting()+"이 대여중인 책입니다.", "선택 에러", JOptionPane.ERROR_MESSAGE);	
				return;
			}
			bookMng.bookDao.delete(isbn);
		} else {
			JOptionPane.showMessageDialog(bookMng, "삭제할 값을 선택해주세요", "선택 에러", JOptionPane.ERROR_MESSAGE);
		}
		updateTable();
	}// end pBookMngDeleteBook

	// 1. table에서 선택된 값을 저장
	// 2. BookInfo에 전달
	// 3. BookInfo에서 전달 받은 객체 표현
	// 4. BookInfo 열기
	// 도서상세정보열기
	public void openBookInfo() {
		bookMng.bookInfo.setEditable(false);
		int row = bookMng.book_table.getSelectedRow();
		if (row != -1) {
			BookDto book = bookMng.bookDao.select((String) bookMng.book_table.getValueAt(row, 2));
			bookMng.bookInfo.setBookDto(book);//2.객체전달
			//3.표현
			bookMng.bookInfo.setTF(book);
			bookMng.imageFile.setImageToLabel(bookMng.bookInfo.lb_img,bookMng.bookInfo.bookDto.getImage_path());
			//4.열기
			bookMng.bookInfo.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(bookMng, "도서를 선택해주세요", "도서선택", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}// end openBookInfo()

	private void updateTable() {
		bookMng.tableModelUpdate();
		bookMng.pMain.tableUpdate();
	}
}
