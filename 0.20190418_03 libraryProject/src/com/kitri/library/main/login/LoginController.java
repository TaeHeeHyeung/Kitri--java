package com.kitri.library.main.login;

import java.awt.Color;
import java.awt.event.*;

public class LoginController implements ActionListener, KeyListener {
	LoginService loginService;
	public Login pLogin;

	public LoginController(Login login) {
		super();
		this.pLogin = login;
		this.loginService = new LoginService(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//패스워드키에서 엔터키
		if (pLogin.pwTF == e.getSource() && e.getKeyCode() == KeyEvent.VK_ENTER) {
			loginService.loginIn(pLogin.idTF.getText(), pLogin.pwTF.getText());
		}
		
		if (pLogin.pwTF == e.getSource() && pLogin.isFirstEnteredKeyPW == false) {
			pLogin.pwTF.setText("");
			pLogin.pwTF.setForeground(Color.BLACK);
			pLogin.isFirstEnteredKeyPW = true;
		}

		if (pLogin.idTF == e.getSource() && pLogin.isFirstEnteredKeyID == false) {
			pLogin.idTF.setText("");
			pLogin.idTF.setForeground(Color.BLACK);
			pLogin.isFirstEnteredKeyID = true;
		}
	}//end keyPressed

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == pLogin.btn_logIn) {// 로그인
			loginService.loginIn(pLogin.idTF.getText(), pLogin.pwTF.getText());
		} // end loginBt
	}

}
