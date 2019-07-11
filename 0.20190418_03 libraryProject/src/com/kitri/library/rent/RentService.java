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

	// 종료
	public void close() {
		rent.lb_ImgMember.setIcon(null);
		rent.tfInit();
		rent.contentsLists = new Vector<>();
		rent.dispose();
	}

	// 대여 가능여부 체크
	public void checkAbleRent() {
		String isbn = rent.tf_bookISBN.getText();
		BookDto bookdto = rent.bookDao.select(isbn);
		MemberDto memberdto = rent.memberDao.select(rent.tf_memId.getText());

		if (bookdto == null) {
			JOptionPane.showMessageDialog(rent, "도서가 존재하지 않습니다.");
			rent.lbl_rentable.setText("책이 존재하지 않습니다.");
		} else if (memberdto == null) {
			JOptionPane.showMessageDialog(rent, "존재하지 않는 회원 번호입니다");
			rent.lbl_rentable.setText("회원이 존재하지 않습니다.");
		} else if (bookdto != null && bookdto.getRenting().equals("no")) {
			rent.lbl_rentable.setText("대여가능");
		} else {
			rent.lbl_rentable.setText("대여불가능: " + bookdto.getRenting() + "이 대여중");
		}
	}// end checkAbleRent

	// 대여 실행
	public void rentProcess() {
		String rentMemberId = rent.tf_memId.getText().trim();
		MemberDao memDao = MemberDao.getInstance();
		MemberDto memDto = memDao.select(rentMemberId);
		if(memDto ==null) {
			JOptionPane.showMessageDialog(rent, "존재하지 않는 회원입니다. 대여 불가");
			System.out.println("존재하지 않는 회원입니다. 대여 불가");
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
		System.out.println("RentService 대여가 완료되었습니다.");
		rent.contentsLists = new Vector<>();
		DefaultTableModel model = new DefaultTableModel(rent.contentsLists, rent.HEADER_LIST);
		rent.table_rent.setModel(model);
		rent.tfInit();
		rent.mainTest.tableUpdate();
		close();
	}

	// 대여리스트 추가
	public void addTable() {
		String isbn = rent.tf_bookISBN.getText();
		BookDto bookDto = rent.bookDao.select(isbn);
		if (bookDto == null) {
			JOptionPane.showMessageDialog(rent, "RentService 해당 도서가 존재하지 않습니다");
//			System.out.println("RentService 해당 도서가 존재하지 않습니다.");
			return;
		}
		int len = rent.contentsLists.size();
		for (int i = 0; i < len; i++) {
			Vector<String> contents = rent.contentsLists.get(i);
			if (isbn.equals(contents.get(2))) {
				JOptionPane.showMessageDialog(rent, "대여리스트에 이미 책이 포함되어있습니다.");
//				System.out.println("RentService 대여리스트에 이미 책이 포함되어있습니다.(확인버튼에서 처리필요)");
				return;
			}
		}
		if (rent.lbl_rentable.getText().equals("대여가능")) {
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
