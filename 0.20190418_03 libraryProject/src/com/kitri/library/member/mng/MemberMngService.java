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

	public void searchData() {// �޺��ڽ��� ��ġ�ϴ� �������� �˻��ϱ�
		int gap = memberMng.comboBox.getSelectedIndex();
		String[] col = { "member_id", "name", "birthday" };
		String search = memberMng.tfSearch.getText();
		memberMng.memberDao.select(col[gap], search);
		memberMng.tableModelUpdate();
	}

	public void deleteRow() {
		int sr = memberMng.table.getSelectedRow();// jtable���� ������ ���� int�� ����־�//�ε������� ������
		if (sr != -1) {
			// System.out.println("���� �����Ͻðڽ��ϱ�?");//���̾�α׷� ���� �ʿ�
			Vector<MemberDto> memberlist = memberMng.memberDao.getList();
			String memberid = memberlist.get(sr).getMember_id();// ������ �ο��� id�޾ƿ���
			BookDao bookDao = BookDao.getInstance();
			Vector<BookDto> vecList = bookDao.selectOfMem(memberid);
			if (vecList.size() != 0) {
				JOptionPane.showMessageDialog(memberMng, "������ �ִ� ������ �����մϴ�.", "���� ����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			memberMng.memberDao.delete(memberid);
			memberMng.tableModelUpdate();
		} else {
			// System.out.println("������ �׸��̾����ϴ�");//���̾�α׷� ���� �ʿ�
		}
	}// end eleteRow

	public void viewAddMember() {
		memberMng.memberAdd.setVisible(true);
	}// end viewAddMember
	// 1. table���� ���õ� ���� ����
	// 2. BookInfo�� ����
	// 3. BookInfo���� ���� ���� ��ü ǥ��
	// 4. BookInfo ����
	// ��������������
	public void viewMemberInfo() {
		int row = memberMng.table.getSelectedRow();
		if (row != -1) {
			MemberDto memDto = memberMng.memberDao.select((String) memberMng.table.getValueAt(row, 0));
			//2��ü����
			memberMng.memberinfo.setMemberDto(memDto);
			//3ǥ��
			memberMng.memberinfo.setTF(memDto);
			memberMng.memberinfo.setTable(memDto);
			memberMng.imageFile.setImageToLabel(memberMng.memberinfo.lbImg,
					memberMng.memberinfo.memberDto.getImage_path());
			System.out.println("MemberMngService imagePath "+memberMng.memberinfo.memberDto.getImage_path());
			//4 ����
			memberMng.memberinfo.setEditable(false);
			memberMng.memberinfo.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(memberMng, "ȸ���� �������ּ���", "��������", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

}
