package com.kitri.library.member.add;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.kitri.library.db.MemberDto;
import com.kitri.library.file.ImageFile;

public class MemberAddService {
	MemberAddController memberAddController;
	MemberAdd memberAdd;
	ImageFile imageFile;

	public MemberAddService(MemberAddController memberAddController) {
		this.memberAddController = memberAddController;
		this.memberAdd = memberAddController.memberAdd;
		this.imageFile = new ImageFile();
	}

	public void addMember() {
		String str = memberAdd.tfAge.getText();
		Date sqlDate = java.sql.Date.valueOf(str);
		// TODO ��¥�Է����� ����ó�� �ʿ�
		if (imageFile.bi != null) {
			imageFile.saveImage(ImageFile.MODE_MEMBER);
		}
		String memberImagePath = imageFile.saveImagePathName;

		if (memberImagePath.equals("")) {
			memberImagePath = "�̹��� ��� ����";
		}
		if (memberAdd.memberDao.select(memberAdd.tfMemberId.getText()) != null) {
			System.out.println("�ش��ϴ� ������̵� �̹� �����մϴ�.");
			return;
		}

		MemberDto memDto = new MemberDto(memberAdd.tfMemberId.getText(),
				memberAdd.group.getSelection().getActionCommand(), memberAdd.tfName.getText(),
				memberAdd.tfPhone.getText(), memberAdd.tfAddress.getText(), memberImagePath, sqlDate);
		memberAdd.memberMng.memberDao.insert(memDto);
		memberAdd.memberMng.tableModelUpdate();
		close();
	}

	public void loadImg() {
		imageFile.viewLoadFile();
		imageFile.setLabelImg_OfLoadImg(memberAdd.lbImg);
	}

	public void loadImageProcess() {
		// Load���� ����, ��� �б�
		imageFile.viewLoadFile();
		// bi���� �ε�
		imageFile.setBufferedImage(imageFile.readImagePathName);
		// �� �̹��� ���̱�
		imageFile.setImageToLabel(memberAdd.lbImg, imageFile.readImagePathName);
	}

	public void close() {
		memberAdd.initContent();
		imageFile.saveImagePathName = "";
		memberAdd.lbImg.setIcon(null);
		imageFile.bi = null;
		memberAdd.dispose();
	}
}
