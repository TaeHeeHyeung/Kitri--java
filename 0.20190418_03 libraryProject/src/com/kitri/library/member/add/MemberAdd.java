package com.kitri.library.member.add;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.library.db.MemberDao;
import com.kitri.library.file.ImageFile;
import com.kitri.library.member.mng.MemberMng;

import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

public class MemberAdd extends JFrame {

	public JPanel contentPane;
	public JTextField tfMemberId;
	public JTextField tfName;
	public JTextField tfAge;
	public JTextField tfPhone;
	public JTextField tfAddress;
	public ButtonGroup group = new ButtonGroup();

	MemberAddController memberAddController;
	public JButton btConfirm;
	public JRadioButton rbMale;
	public JRadioButton rbFemale;
	public MemberMng memberMng;
	public JLabel lbImg;
	public JButton btImg;
	public ImageFile imageFile;
	public MemberDao memberDao;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// MemberAdd frame = new MemberAdd(null);
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public MemberAdd(MemberMng memberMng) {
		this.memberMng = memberMng;
		this.memberDao = memberMng.memberDao;
		this.imageFile = memberMng.imageFile;
		memberAddController = new MemberAddController(this);
		uiInit();
		initContent();
		setLocationRelativeTo(null); // 프레임을 화면 정가운데 위치 /키워드 :중앙, 가운데

		// 리스너등록
		// 순차 종료 막기WindowListener
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		btConfirm.addActionListener(memberAddController);
		btImg.addActionListener(memberAddController);

		// 퍼블리쉬데이트 글씨 제거
		// 퍼블리쉬데이트 글씨 제거
		tfAge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfAge.setText("");
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				memberAddController.memberService.close();
			}
		});

	}

	private void uiInit() {
		setTitle("\uD68C\uC6D0\uCD94\uAC00");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbNum = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		lbNum.setBounds(126, 10, 75, 28);
		contentPane.add(lbNum);

		tfMemberId = new JTextField();
		tfMemberId.setColumns(10);
		tfMemberId.setBounds(203, 10, 192, 28);
		contentPane.add(tfMemberId);

		JLabel lbName = new JLabel("\uC774\uB984");
		lbName.setBounds(126, 50, 75, 28);
		contentPane.add(lbName);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(203, 50, 192, 28);
		contentPane.add(tfName);

		JLabel lbAge = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lbAge.setBounds(126, 90, 75, 28);
		contentPane.add(lbAge);

		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(203, 90, 192, 28);
		contentPane.add(tfAge);

		JLabel lbGender = new JLabel("\uC131\uBCC4");
		lbGender.setBounds(126, 130, 75, 28);
		contentPane.add(lbGender);
		rbMale = new JRadioButton("\uB0A8\uC131", true);
		rbMale.setBounds(203, 130, 96, 28);
		rbMale.setActionCommand("남자");
		contentPane.add(rbMale);
		group.add(rbMale);

		rbFemale = new JRadioButton("\uC5EC\uC131");
		rbFemale.setBounds(299, 130, 96, 28);
		rbFemale.setActionCommand("여자");
		contentPane.add(rbFemale);
		group.add(rbFemale);

		JLabel lbPhone = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638");
		lbPhone.setBounds(126, 170, 75, 28);
		contentPane.add(lbPhone);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(203, 170, 192, 28);
		contentPane.add(tfPhone);

		JLabel lbAddress = new JLabel("\uC8FC\uC18C");
		lbAddress.setBounds(126, 210, 75, 28);
		contentPane.add(lbAddress);

		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(203, 210, 192, 28);
		contentPane.add(tfAddress);

		btConfirm = new JButton("\uD655\uC778");
		btConfirm.setFont(new Font("굴림", Font.PLAIN, 12));
		btConfirm.setBounds(322, 248, 75, 27);
		contentPane.add(btConfirm);

		lbImg = new JLabel("");
		lbImg.setOpaque(true);
		lbImg.setBackground(Color.WHITE);
		lbImg.setBounds(12, 17, 102, 114);

		contentPane.add(lbImg);

		btImg = new JButton("\uC774\uBBF8\uC9C0\uCD94\uAC00");
		btImg.setBounds(12, 152, 102, 23);
		contentPane.add(btImg);
	}

	public void initContent() {
		lbImg.setIcon(null);
		tfAge.setText("'2019-04-17' 식으로 입력해주세요.");
		tfMemberId.setText("");
		tfName.setText("");
		tfPhone.setText("");
		tfAddress.setText("");
		
	}


}
