package com.kitri.library.member.info;

import java.sql.Date;

import com.kitri.library.bookmng.bookinfo.BookInfo;
import com.kitri.library.db.*;
import com.kitri.library.file.ImageFile;

public class MemberInfoService {

	private Memberinfo memberinfo;
	private ImageFile imageFile;
	private MemberDao memDao;

	public MemberInfoService(MemberInfoController memberInfoController) {
		this.memberinfo = memberInfoController.memberinfo;
		memDao = MemberDao.getInstance();
		imageFile = new ImageFile();
	}

	public void setEditable() {
		memberinfo.setEditable(true);
		memberinfo.cardlayout.show(memberinfo.panelCard, Memberinfo.BT_CONFIRM);
	}

	// imageFile bi 정보 로드
	public void readImage() {
		// Load파일 열기, 경로 읽기
		imageFile.viewLoadFile();
		// bi정보 로드
		imageFile.setBufferedImage(imageFile.readImagePathName);
		// 라벨 이미지 붙이기
		if (imageFile.bi != null) {
			imageFile.setImageToLabel(memberinfo.lbImg, imageFile.readImagePathName);
		}
	}

	public void editConfirm() {
		String memberId = memberinfo.tfMember_id.getText();
		MemberDto memberDto = memDao.select(memberId);

		// 이미지 저장,저장할 경로 설정
		String imagePath = "";
		if (imageFile.bi != null) {
			imageFile.saveImage(ImageFile.MODE_MEMBER);
			imagePath = imageFile.saveImagePathName;
		} else {
			imagePath = memberDto.getImage_path();
		}

		memberDto.setImage_path(imagePath);
		memberDto.setBirthday(java.sql.Date.valueOf(memberinfo.tfDate.getText().trim()));
		memberDto.setMember_id(memberinfo.tfMember_id.getText());
		memberDto.setMember_name(memberinfo.tfName.getText());
		memberDto.setGender(memberinfo.tfGender.getText());
		memberDto.setPhone_number(memberinfo.tfPhone.getText());

		if (memDao.update(memberId, memberDto)) {
			System.out.println("값변경 성공");
		} else {
			System.out.println("값변경 실패");
		}
		memberinfo.setEditable(false);
		memberinfo.cardlayout.show(memberinfo.panelCard, Memberinfo.BT_MODIFY);
		// updateTable();
		memberinfo.memberMng.tableModelUpdate();
//		close();
	}

	public void close() {
		imageFile.close();
		memberinfo.setEditable(false);
		memberinfo.lbImg.setIcon(null);
		memberinfo.cardlayout.show(memberinfo.panelCard, Memberinfo.BT_MODIFY);
		memberinfo.dispose();
	}

}
