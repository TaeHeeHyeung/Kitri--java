package com.kitri.library.main.login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.kitri.library.controller.Controller;
import com.kitri.library.controller.Service;
import com.kitri.library.db.MenagerDao;
import com.kitri.library.main.start.StartTest;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.*;
import java.awt.Cursor;

public class Login extends JPanel {
	public MenagerDao menagerDao;
	
	public JTextField idTF;
	public JTextField pwTF;
	public final String STR_ID_PW = "내용을 입력하세요.";
	public JButton btn_logIn;
	public boolean isFirstEnteredKeyID = false;
	public boolean isFirstEnteredKeyPW = false;


	public StartTest startTest;

	public LoginController loginController;
	public LoginService loginService;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login frame = new Login();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});	
//	}


	/**
	 * Create the frame.
	 */
	public Login(StartTest startTest ) {
		this.startTest= startTest;
		loginController= new LoginController(this);
		menagerDao= new MenagerDao();
		setBounds(0, 0, 800, 800);

		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

		JLabel labelid = new JLabel("\uC544\uC774\uB514 ");
		labelid.setFont(new Font("굴림", Font.PLAIN, 12));
		labelid.setForeground(SystemColor.inactiveCaptionText);
		labelid.setBounds(276, 470, 54, 36);
		add(labelid);

		JLabel labelpw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		labelpw.setFont(new Font("굴림", Font.PLAIN, 12));
		labelpw.setForeground(SystemColor.inactiveCaptionText);
		labelpw.setBounds(264, 529, 54, 30);
		add(labelpw);

		btn_logIn = new JButton("\uB85C\uADF8\uC778");
		btn_logIn.setBounds(485, 478, 75, 79);
		add(btn_logIn);

		JLabel labelLb = new JLabel("\uD0A4\uD2B8\uB9AC \uB3C4\uC11C\uAD00");
		labelLb.setFont(new Font("굴림", Font.BOLD, 54));
		labelLb.setForeground(UIManager.getColor("Button.disabledForeground"));
		labelLb.setHorizontalAlignment(SwingConstants.CENTER);
		labelLb.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		labelLb.setBounds(123, 116, 552, 209);
		add(labelLb);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.infoText);
		panel.setBounds(0, 0, 784, 18);
		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.infoText);
		panel_1.setBounds(0, 744, 784, 18);
		add(panel_1);

//		idTF.setBackground(Color.GRAY);
//		idTF.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				idTF.setEditable(true);
//				idTF.setText("");
//				idTF.getCaret().setVisible(true); // 커서가 보이게함
//			}
//		});
//		pwTF.setBackground(Color.GRAY);
//		pwTF.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				pwTF.setEditable(true);
//				pwTF.setText("");
//				pwTF.getCaret().setVisible(true);
//			}
//		});

		JPanel panel_tf = new JPanel();
		panel_tf.setBackground(Color.WHITE);
		panel_tf.setBounds(328, 464, 159, 107);
		add(panel_tf);
		panel_tf.setLayout(null);

		idTF = new JTextField();
		idTF.setBounds(12, 10, 131, 30);
		panel_tf.add(idTF);
		idTF.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		idTF.setText(STR_ID_PW);
		idTF.setColumns(10);
		idTF.setBackground(Color.white);

		pwTF = new JTextField();
		pwTF.setBounds(12, 67, 131, 30);
		panel_tf.add(pwTF);
		pwTF.setText(STR_ID_PW);
		pwTF.setColumns(10);
		pwTF.setBackground(Color.white);

		
		// 리스너 등록
		btn_logIn.addActionListener(loginController);
		pwTF.addKeyListener(loginController);
		idTF.addKeyListener(loginController);
		
		initTF();
	}// end Login

	public void initTF() {
		isFirstEnteredKeyID = false;
		idTF.setText(STR_ID_PW);
		isFirstEnteredKeyPW = false;
		pwTF.setText(STR_ID_PW);
		idTF.setForeground(Color.GRAY);
		pwTF.setForeground(Color.GRAY);
	}
}// end Login Class
