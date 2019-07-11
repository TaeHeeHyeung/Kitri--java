package com.kitri.library.member.info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberInfoController implements ActionListener {
	public MemberInfoService memInfoService;
	public Memberinfo memberinfo;

	public MemberInfoController(Memberinfo memberinfo) {
		this.memberinfo = memberinfo;
		memInfoService = new MemberInfoService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == memberinfo.btImg) {
			memInfoService.readImage();
		} else if (obj == memberinfo.btModify) {
			memInfoService.setEditable();
		} else if (obj == memberinfo.btConfirm) {
			memInfoService.editConfirm();
		} else if (obj == memberinfo.btOk) {
			memInfoService.close();
		}
	}// end actionPerformed
}
