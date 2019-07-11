package com.kitri.library.member.mng;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.library.member.info.Memberinfo;

public class MemberController implements ActionListener {
	MemberMng memberMng;
	MemberMngService memberService;
	public Memberinfo memberInfo;

	public MemberController(MemberMng memberMng) {
		this.memberMng = memberMng;
		memberService = new MemberMngService(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == memberMng.btSearch) {
			memberService.searchData();
		} else if (ob == memberMng.btAdd) {
			memberService.viewAddMember();
		} else if (ob == memberMng.btDelete) {
			memberService.deleteRow();
		} else if (ob == memberMng.btCancel) {
			memberService.close();
		}else if (ob == memberMng.btUpdate) {
			memberService.viewMemberInfo();
		}
	}
}
