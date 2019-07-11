package com.kitri.library.member.add;

import java.awt.event.*;

import com.kitri.library.member.mng.MemberMngService;

public class MemberAddController implements ActionListener {
	MemberAdd memberAdd;
	MemberAddService memberService;

	public MemberAddController(MemberAdd memberAdd) {
		this.memberAdd = memberAdd;
		this.memberService = new MemberAddService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == memberAdd.btConfirm) {
			memberService.addMember();
		}else if (obj == memberAdd.btImg) {
			memberService.loadImg();
		}
	}
	

}
