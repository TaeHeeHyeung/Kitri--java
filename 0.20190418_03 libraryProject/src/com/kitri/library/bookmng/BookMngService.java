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

	// ���� �߰� ����.
	public void viewBookAdd() {
		bookMng.pBookAdd.setVisible(true);
	}// end viewBookAdd()

	// ���� �˻�
	public void bookSearchBookMng(String searchMethodStr, String searchStr) {
		Vector<BookDto> list = bookMng.bookDao.getList(searchMethodStr, searchStr);
		// ���� �߰��� ������
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
		// �����Ϸ��� model�� �߰��ؾ��Ѵ�.
		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
		bookMng.book_table.setModel(model);
	}

	// ���������� �������� ����
	public void pBookMngDeleteBook() {
		// ���̺� ���õ� �� ����
		int row = bookMng.book_table.getSelectedRow();
		if (row != -1) {
			String isbn = (String) bookMng.book_table.getValueAt(row, 2);
			BookDto bDto = bookMng.bookDao.select(isbn);
			if(!bDto.getRenting().equals("no")) {
				JOptionPane.showMessageDialog(bookMng, bDto.getRenting()+"�� �뿩���� å�Դϴ�.", "���� ����", JOptionPane.ERROR_MESSAGE);	
				return;
			}
			bookMng.bookDao.delete(isbn);
		} else {
			JOptionPane.showMessageDialog(bookMng, "������ ���� �������ּ���", "���� ����", JOptionPane.ERROR_MESSAGE);
		}
		updateTable();
	}// end pBookMngDeleteBook

	// 1. table���� ���õ� ���� ����
	// 2. BookInfo�� ����
	// 3. BookInfo���� ���� ���� ��ü ǥ��
	// 4. BookInfo ����
	// ��������������
	public void openBookInfo() {
		bookMng.bookInfo.setEditable(false);
		int row = bookMng.book_table.getSelectedRow();
		if (row != -1) {
			BookDto book = bookMng.bookDao.select((String) bookMng.book_table.getValueAt(row, 2));
			bookMng.bookInfo.setBookDto(book);//2.��ü����
			//3.ǥ��
			bookMng.bookInfo.setTF(book);
			bookMng.imageFile.setImageToLabel(bookMng.bookInfo.lb_img,bookMng.bookInfo.bookDto.getImage_path());
			//4.����
			bookMng.bookInfo.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(bookMng, "������ �������ּ���", "��������", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}// end openBookInfo()

	private void updateTable() {
		bookMng.tableModelUpdate();
		bookMng.pMain.tableUpdate();
	}
}
