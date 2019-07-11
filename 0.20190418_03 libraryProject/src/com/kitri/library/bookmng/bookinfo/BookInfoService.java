package com.kitri.library.bookmng.bookinfo;

import java.sql.Date;

import javax.swing.JOptionPane;

import com.kitri.library.bookmng.BookMng;
import com.kitri.library.db.BookDto;
import com.kitri.library.file.ImageFile;
import com.kitri.library.main.main.MainTest;

public class BookInfoService {
	BookInfo bookInfo;
	BookInfoController pBookInfoController;
	private BookMng pBookMng;
	private MainTest pMain;
	private ImageFile imageFile;

	public BookInfoService(BookInfoController pBookInfoController) {
		super();
		this.pBookInfoController = pBookInfoController;

		pMain = pBookInfoController.pMainTest;
		pBookMng = pBookInfoController.pBookMng;
		bookInfo = pBookInfoController.pBookInfo;
		imageFile = new ImageFile();
	}

	// 도서정보 변경 열기
	public void editBookProcess() {
		bookInfo.cardLayout.show(bookInfo.panel_cardLayout, BookInfo.BT_EDIT_CONFIRM);
		String isbn = bookInfo.tfISBN.getText();
		BookDto beforeBook = bookInfo.bookDao.select(isbn);
		// System.out.println("BookInfoService.editBookProcess "+
		// beforeBook.getImage_path());
		bookInfo.setBookDto(beforeBook);
		bookInfo.setEditable(true);
	}// end editBookProcess
		// ---------------------------도서 추가

	// imageFile bi정보 세이브
	public void bookEditConfirm() {
		// 날짜
		String isbn = bookInfo.tfISBN.getText();
		String str = bookInfo.tfBookPublishDate.getText();
		Date sqlDate = java.sql.Date.valueOf(str);
		// 이미지정보 저장
		BookDto bookDto = bookInfo.bookDao.select(isbn);
		String imagePath = "";
		if (imageFile.bi != null) {
			imageFile.saveImage(ImageFile.MODE_BOOK);
			imagePath = imageFile.saveImagePathName;
			System.out.println("BookInfoService "+imagePath);
		} else {
			imagePath = bookDto.getImage_path();
		}

		// bookDto.setIsbn(bookInfo.tfISBN.getText().trim());
		bookDto.setName(bookInfo.tfBookName.getText().trim());
		bookDto.setPosition(bookInfo.tfBookPosition.getText().trim());
		bookDto.setPublish_date(sqlDate);
		bookDto.setPublisher(bookInfo.tfBookPublisher.getText().trim());
		// bookdto.setRenting(bookdto.getRenting());
		bookDto.setWriter(bookInfo.tfBookWriter.getText().trim());
		bookDto.setImage_path(imagePath);
		bookInfo.bookDao.upDateBook(isbn, bookDto);
		updateTable();
		bookInfo.setEditable(false);
//		bookInfo.setVisible(false);
		bookInfo.cardLayout.show(bookInfo.panel_cardLayout, BookInfo.BT_EDIT);
//		close();
	}

	// 테이블 갱신
	private void updateTable() {
		pBookMng.tableModelUpdate();
		pMain.tableUpdate();
	}

	public void close() {
		imageFile.close();
		bookInfo.lb_img.setIcon(null);
		bookInfo.tfInit();
		bookInfo.cardLayout.show(bookInfo.panel_cardLayout, bookInfo.BT_EDIT);
		bookInfo.dispose();
	}

	// imageFile bi 정보 로드
	public void readImage() {
		// Load파일 열기, 경로 읽기
		imageFile.viewLoadFile();
		// bi정보 로드
		imageFile.setBufferedImage(imageFile.readImagePathName);
		// 라벨 이미지 붙이기
		if (imageFile.bi != null) {
			imageFile.setImageToLabel(bookInfo.lb_img, imageFile.readImagePathName);
		}
		// 이미지 저장할 경로 설정
		// bookInfo.bookDto.setImage_path(imageFile.saveImagePathName);
	}

}// BookInfoService

// 도서상세정보열기
// public void openBookInfo() {
// int row = pBookMng.book_table.getSelectedRow();
// if (row != -1) {
// String isbn = (String) pBookMng.book_table.getValueAt(row, 2);
// pBookInfo.setVisible(true);
// BookDto book = pBookInfo.bookDao.getBook(isbn);
// pBookInfo.tfBookName.setText(book.getName());
// pBookInfo.tfBookPosition.setText(book.getPosition());
// String dateStr = book.getPublish_date().toString();
// pBookInfo.tfBookPublishDate.setText(dateStr);
// pBookInfo.tfBookPublisher.setText(book.getPublisher());
// pBookInfo.tfBookWriter.setText(book.getWriter());
// pBookInfo.tfISBN.setText(book.getIsbn());
// pBookInfo.imagePathStr = "image_path";
// imageFile.setImage(pBookInfo.lb_img);
//// pBookInfo.tfImgPath.setText(book.getImage_path());
// } else {
// JOptionPane.showMessageDialog(pBookInfo, "도서를 선택해주세요", "도서선택",
// JOptionPane.ERROR_MESSAGE);
// return;
// }
// }// end openBookInfo()
