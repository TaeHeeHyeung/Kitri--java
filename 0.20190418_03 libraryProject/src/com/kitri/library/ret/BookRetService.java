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

	// �ݳ�����Ʈ �߰�
	public void addRet() {
		String tfISBN = bookReturn.tf_isbn.getText();
		BookDto bookDto = bookReturn.bookDao.select(tfISBN);

		if (bookDto == null) {
			JOptionPane.showMessageDialog(bookReturn, "�ش� ������ �������� �ʽ��ϴ�.");
			return;
		}else if(bookDto.getRenting().equals("no")) {
			JOptionPane.showMessageDialog(bookReturn, "�̹� �ݳ� ó���� å�Դϴ�.");
			
			return;
		}
		int len = bookReturn.contentsVec.size();
		for (int i = 0; i < len; i++) {
			Vector<String> contents = bookReturn.contentsVec.get(i);
			if (tfISBN.equals(contents.get(2))) {
				JOptionPane.showMessageDialog(bookReturn, "�̹� �ݳ� ����Ʈ�� ���ԵǾ��ֽ��ϴ�.");
				return;
			}
		}
		// "������", "����", "ISBN", "û����ȣ", "�뿩��", "�ݳ���"
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

	//�ݳ��ϱ�
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
		JOptionPane.showMessageDialog(bookReturn, "�ݳ��� �Ϸ�Ǿ����ϴ�.");
		bookReturn.mainTest.tableUpdate();
	}
}// end BookRetService class
