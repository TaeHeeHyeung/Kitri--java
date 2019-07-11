package com.kitri.library.main.login;

import java.util.List;

import javax.swing.JOptionPane;

import com.kitri.library.db.MenagerDto;
import com.kitri.library.main.start.StartTest;

public class LoginService {
	LoginController loginController;
	Login pLogin;
	StartTest pStartTest;
	
	public LoginService(LoginController loginController) {
		super();
		this.loginController = loginController;
		this.pLogin = loginController.pLogin;
		this.pStartTest = loginController.pLogin.startTest;
	}

	public void loginIn(String id, String pass) {
		List<MenagerDto> menagerList = pLogin.menagerDao.getList();
		int len = menagerList.size();
		for (int i = 0; i < len; i++) {
			String menager_id = menagerList.get(i).getId();
			String menager_pass = menagerList.get(i).getPassword();
			System.out.println(id + " " + pass + " ");
			if (menager_id.equals(id) && menager_pass.equals(pass)) {
				pLogin.idTF.setText("");
				pLogin.pwTF.setText("");
				pStartTest.cardLayout.show(pStartTest.panel_cardLayout, StartTest.CARD_STR_PMAINTEST);
				pLogin.setVisible(false);
				pStartTest.pMainTest.setVisible(true);
				return;
			}
		} // end for
		String[] buttons = { "확인" };
		JOptionPane.showOptionDialog(null, "로그인에 실패 하였습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE, 0, null, buttons,
				buttons[0]);
	}// end loginIn
}
