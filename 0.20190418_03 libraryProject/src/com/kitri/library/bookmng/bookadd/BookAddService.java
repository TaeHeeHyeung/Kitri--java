package com.kitri.library.bookmng.bookadd;

import java.awt.FileDialog;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Vector;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.kitri.library.bookmng.BookMng;
import com.kitri.library.db.BookDto;
import com.kitri.library.file.ImageFile;
import com.kitri.library.main.main.MainTest;

public class BookAddService {
	BookAdd bookAdd;
	BookAddController bookAddController;

	private BookMng pBookMng;
	private MainTest pMainTest;

	private ImageFile imageFile;

	public BookAddService(BookAddController bookAddController) {
		this.bookAddController = bookAddController;
		bookAdd = bookAddController.pBookAdd;
		pBookMng = bookAddController.pBookMng;
		pMainTest = bookAddController.pMainTest;
		imageFile = new ImageFile();
	}

	public void addBook() {
		String str = bookAdd.tfPubDate.getText();
		Date sqlDate = java.sql.Date.valueOf(str);
		// TODO ��¥�Է����� ����ó�� �ʿ�
		if (imageFile.bi != null) {
			imageFile.saveImage(ImageFile.MODE_BOOK);
		}
		String imagePath = imageFile.saveImagePathName;

		if (imagePath.equals("")) {
			imagePath = "�̹��� ��� ����";
		}
		if (bookAdd.bookDao.select(bookAdd.tfIsbn.getText()) != null) {
			System.out.println("�ش��ϴ� ISBN å�� �̹� �����մϴ�.");
			return;
		}

		BookDto bookDto = new BookDto(bookAdd.tfIsbn.getText(), bookAdd.tfBookName.getText(),
				bookAdd.tfAuthor.getText(), imagePath, bookAdd.tfGenre.getText(), bookAdd.tfBookPub.getText(),
				bookAdd.tfCall.getText(), sqlDate, "no");
		bookAdd.bookDao.insert(bookDto);
		

		updateTable();
		imageFile.close();
		close();
	} // end addBook()
		// ���̺� ����

	private void updateTable() {
		pBookMng.tableModelUpdate();
		pMainTest.tableUpdate();
	}

	//
	public void loadImageProcess() {
		// Load���� ����, ��� �б�
		imageFile.viewLoadFile();
		// bi���� �ε�
		imageFile.setBufferedImage(imageFile.readImagePathName);
		// �� �̹��� ���̱�
		imageFile.setImageToLabel(bookAdd.lbImg, imageFile.readImagePathName);
	}

	
	public void close() {
		bookAdd.initContent("");
		imageFile.saveImagePathName = "";
		bookAdd.lbImg.setIcon(null);
		imageFile.bi= null;
		bookAdd.dispose();
	}
}
