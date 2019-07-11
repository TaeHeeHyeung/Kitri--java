package com.kitri.library.ret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookRetController implements ActionListener {

	BookRetService bookRetService;
	public BookReturn bookReturn;

	public BookRetController(BookReturn bookRet) {
		this.bookReturn = bookRet;
		bookRetService = new BookRetService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == bookReturn.bt_confirm) {
			bookRetService.retConfirm();
		} else if (obj == bookReturn.bt_addList) {
			bookRetService.addRet();
		}
	}

}
