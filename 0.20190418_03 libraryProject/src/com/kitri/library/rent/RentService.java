package com.kitri.library.rent;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.kitri.library.db.*;

public class RentService {
	RentController rentController;
	Rent rent;

	public RentService(RentController rentController) {
		this.rentController = rentController;
		rent = rentController.rent;
	}

	// ����
	public void close() {
		rent.lb_ImgMember.setIcon(null);
		rent.tfInit();
		rent.contentsLists = new Vector<>();
		rent.dispose();
	}

	// �뿩 ���ɿ��� üũ
	public void checkAbleRent() {
		String isbn = rent.tf_bookISBN.getText();
		BookDto bookdto = rent.bookDao.select(isbn);
		MemberDto memberdto = rent.memberDao.select(rent.tf_memId.getText());

		if (bookdto == null) {
			JOptionPane.showMessageDialog(rent, "������ �������� �ʽ��ϴ�.");
			rent.lbl_rentable.setText("å�� �������� �ʽ��ϴ�.");
		} else if (memberdto == null) {
			JOptionPane.showMessageDialog(rent, "�������� �ʴ� ȸ�� ��ȣ�Դϴ�");
			rent.lbl_rentable.setText("ȸ���� �������� �ʽ��ϴ�.");
		} else if (bookdto != null && bookdto.getRenting().equals("no")) {
			rent.lbl_rentable.setText("�뿩����");
		} else {
			rent.lbl_rentable.setText("�뿩�Ұ���: " + bookdto.getRenting() + "�� �뿩��");
		}
	}// end checkAbleRent

	// �뿩 ����
	public void rentProcess() {
		String rentMemberId = rent.tf_memId.getText().trim();
		MemberDao memDao = MemberDao.getInstance();
		MemberDto memDto = memDao.select(rentMemberId);
		if(memDto ==null) {
			JOptionPane.showMessageDialog(rent, "�������� �ʴ� ȸ���Դϴ�. �뿩 �Ұ�");
			System.out.println("�������� �ʴ� ȸ���Դϴ�. �뿩 �Ұ�");
			return;
		}
		int len = rent.contentsLists.size();
		for (int i = 0; i < len; i++) {
			Vector<String> contents = rent.contentsLists.get(i);
			String isbn = contents.get(2);
			BookDto bookDto = rent.bookDao.select(isbn);
			bookDto.setRenting(rentMemberId);
			rent.bookDao.upDateBook(isbn, bookDto);
		}
		System.out.println("RentService �뿩�� �Ϸ�Ǿ����ϴ�.");
		rent.contentsLists = new Vector<>();
		DefaultTableModel model = new DefaultTableModel(rent.contentsLists, rent.HEADER_LIST);
		rent.table_rent.setModel(model);
		rent.tfInit();
		rent.mainTest.tableUpdate();
		close();
	}

	// �뿩����Ʈ �߰�
	public void addTable() {
		String isbn = rent.tf_bookISBN.getText();
		BookDto bookDto = rent.bookDao.select(isbn);
		if (bookDto == null) {
			JOptionPane.showMessageDialog(rent, "RentService �ش� ������ �������� �ʽ��ϴ�");
//			System.out.println("RentService �ش� ������ �������� �ʽ��ϴ�.");
			return;
		}
		int len = rent.contentsLists.size();
		for (int i = 0; i < len; i++) {
			Vector<String> contents = rent.contentsLists.get(i);
			if (isbn.equals(contents.get(2))) {
				JOptionPane.showMessageDialog(rent, "�뿩����Ʈ�� �̹� å�� ���ԵǾ��ֽ��ϴ�.");
//				System.out.println("RentService �뿩����Ʈ�� �̹� å�� ���ԵǾ��ֽ��ϴ�.(Ȯ�ι�ư���� ó���ʿ�)");
				return;
			}
		}
		if (rent.lbl_rentable.getText().equals("�뿩����")) {
			String[] strArr = new String[] { bookDto.getName(), bookDto.getWriter(), bookDto.getIsbn(),
					bookDto.getPublisher(), bookDto.getPublish_dateStr(), rent.tf_memId.getText() };// bookDto.getRenting()
			int lenStr = strArr.length;
			Vector<String> content = new Vector<>();
			for (int j = 0; j < lenStr; j++) {
				content.add(strArr[j]);
			}
			rent.contentsLists.add(content);
			DefaultTableModel model = new DefaultTableModel(rent.contentsLists, rent.HEADER_LIST);
			rent.table_rent.setModel(model);
		}
	}// end addTable

}
