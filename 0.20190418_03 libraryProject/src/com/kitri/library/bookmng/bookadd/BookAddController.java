package com.kitri.library.bookmng.bookadd;

import java.awt.FileDialog;
import java.awt.event.*;

import com.kitri.library.bookmng.BookMng;
import com.kitri.library.main.main.MainTest;

public class BookAddController extends WindowAdapter implements ActionListener {
	BookAddService bookAddService;
	BookAdd pBookAdd;

	public MainTest pMainTest;
	public BookMng pBookMng;

	public BookAddController(BookAdd bookAdd) {
		this.pBookAdd = bookAdd;
		this.pBookMng = bookAdd.pBookMng;
		this.pMainTest = bookAdd.pBookMng.pMain;
		bookAddService = new BookAddService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == pBookAdd.btOk) {
			bookAddService.addBook();
		} else if (obj == pBookAdd.btImg) {
			bookAddService.loadImageProcess();
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		bookAddService.close();
	}

}
