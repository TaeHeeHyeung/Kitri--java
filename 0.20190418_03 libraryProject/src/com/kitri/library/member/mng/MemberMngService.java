package com.kitri.library.member.mng;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kitri.library.db.*;
import com.kitri.library.file.ImageFile;
import com.kitri.library.member.add.MemberAddController;
import com.kitri.library.member.info.Memberinfo;

public class MemberMngService {

	MemberController memberController;
	MemberMng memberMng;

	public MemberMngService(MemberController memberController) {
		this.memberController = memberController;
		this.memberMng = memberController.memberMng;
	}

	public void close() {
		memberMng.dispose();
	}

	public void searchData() {// 콤보박스에 일치하는 기준으로 검색하기
		int gap = memberMng.comboBox.getSelectedIndex();
		String[] col = { "member_id", "name", "birthday" };
		String search = memberMng.tfSearch.getText();
		memberMng.memberDao.select(col[gap], search);
		memberMng.tableModelUpdate();
	}

	public void deleteRow() {
		int sr = memberMng.table.getSelectedRow();// jtable에서 선택한 행을 int에 집어넣어//인덱스값을 리턴함
		if (sr != -1) {
			// System.out.println("정말 삭제하시겠습니까?");//다이얼로그로 띄우기 필요
			Vector<MemberDto> memberlist = memberMng.memberDao.getList();
			String memberid = memberlist.get(sr).getMember_id();// 선택한 로우의 id받아오기
			BookDao bookDao = BookDao.getInstance();
			Vector<BookDto> vecList = bookDao.selectOfMem(memberid);
			if (vecList.size() != 0) {
				JOptionPane.showMessageDialog(memberMng, "빌리고 있는 도서가 존재합니다.", "선택 에러", JOptionPane.ERROR_MESSAGE);
				return;
			}
			memberMng.memberDao.delete(memberid);
			memberMng.tableModelUpdate();
		} else {
			// System.out.println("선택한 항목이없습니다");//다이얼로그로 띄우기 필요
		}
	}// end eleteRow

	public void viewAddMember() {
		memberMng.memberAdd.setVisible(true);
	}// end viewAddMember
	// 1. table에서 선택된 값을 저장
	// 2. BookInfo에 전달
	// 3. BookInfo에서 전달 받은 객체 표현
	// 4. BookInfo 열기
	// 도서상세정보열기
	public void viewMemberInfo() {
		int row = memberMng.table.getSelectedRow();
		if (row != -1) {
			MemberDto memDto = memberMng.memberDao.select((String) memberMng.table.getValueAt(row, 0));
			//2객체전달
			memberMng.memberinfo.setMemberDto(memDto);
			//3표현
			memberMng.memberinfo.setTF(memDto);
			memberMng.memberinfo.setTable(memDto);
			memberMng.imageFile.setImageToLabel(memberMng.memberinfo.lbImg,
					memberMng.memberinfo.memberDto.getImage_path());
			System.out.println("MemberMngService imagePath "+memberMng.memberinfo.memberDto.getImage_path());
			//4 열기
			memberMng.memberinfo.setEditable(false);
			memberMng.memberinfo.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(memberMng, "회원을 선택해주세요", "도서선택", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

}
