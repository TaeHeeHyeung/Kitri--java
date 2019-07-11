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
		// TODO 날짜입력형식 예외처리 필요
		if (imageFile.bi != null) {
			imageFile.saveImage(ImageFile.MODE_MEMBER);
		}
		String memberImagePath = imageFile.saveImagePathName;

		if (memberImagePath.equals("")) {
			memberImagePath = "이미지 경로 없음";
		}
		if (memberAdd.memberDao.select(memberAdd.tfMemberId.getText()) != null) {
			System.out.println("해당하는 멤버아이디가 이미 존재합니다.");
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
		// Load파일 열기, 경로 읽기
		imageFile.viewLoadFile();
		// bi정보 로드
		imageFile.setBufferedImage(imageFile.readImagePathName);
		// 라벨 이미지 붙이기
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
