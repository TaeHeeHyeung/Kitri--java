package com.kitri.library.main.start;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kitri.library.bookmng.*;
import com.kitri.library.bookmng.bookadd.BookAdd;
import com.kitri.library.bookmng.bookinfo.BookInfo;
import com.kitri.library.controller.Controller;
import com.kitri.library.main.login.Login;
import com.kitri.library.main.main.MainTest;
import com.kitri.library.member.mng.MemberMng;
import com.kitri.library.rent.Rent;
import com.kitri.library.ret.BookReturn;

public class StartTest extends JFrame {

	public static final String CARD_STR_PMAINTEST = "pMainTest";
	public static final String CARD_STR_PLOGIN = "pLogin";

//	Controller controller;
	public Login pLogin;
	public MainTest pMainTest;
	StartController startControler;

	private JPanel contentPane;
	public JPanel panel_cardLayout;
	public CardLayout cardLayout = new CardLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartTest frame = new StartTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}// end main

	/**
	 * Create the frame.
	 */
	public StartTest() {
		setBounds(new Rectangle(0, 0, 800, 800));
		pLogin = new Login(this); // �α���ȭ�� -> ����ȭ��
		pMainTest = new MainTest(this); // ����ȭ��

		startControler = new StartController(this);// Controller�� ��ü���� �ڿ� �;ߵȴ�.
		uiInit();
		setLocationRelativeTo(null); // �������� ȭ�� ����� ��ġ Ű���� :�߾�, ���
		// ������ �ٲٸ� �α���â���� ���� ����
		panel_cardLayout.add(pLogin, CARD_STR_PLOGIN);
		panel_cardLayout.add(pMainTest, CARD_STR_PMAINTEST);
	}// end CardLayoutTest

	public void uiInit() {
		setTitle("\uD0A4\uD2B8\uB9AC \uB3C4\uC11C\uAD00");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		setBounds(0, 0, 800, 800);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_cardLayout = new JPanel();
		panel_cardLayout.setBounds(0, 0, 800, 800);
		panel_cardLayout.setLayout(cardLayout);
		contentPane.add(panel_cardLayout);
	}

}// end class
