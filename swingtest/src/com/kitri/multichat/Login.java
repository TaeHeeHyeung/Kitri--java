package com.kitri.multichat;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Login extends JFrame {
	private final JPanel panel = new JPanel();
	private final JPanel panel_btn = new JPanel();
	private final JButton ok = new JButton("\uD655\uC778");
	private final JButton cancel = new JButton("\uCDE8\uC18C");
	private final JLabel lable_IP = new JLabel("I        P :");
	private final JLabel label_talkName = new JLabel("\uB300 \uD654 \uBA85 :");
	private final JTextField ipTF = new JTextField();
	private final JTextField nameTF = new JTextField();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login() {
		super("Login!!");
		ipTF.setBounds(102, 48, 321, 21);
		ipTF.setColumns(10);
		getContentPane().setBackground(Color.WHITE);
		
		setDefaultLookAndFeelDecorated(true);
		setBounds(300, 300, 500, 300);
		getContentPane().setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 460, 242);
		
		getContentPane().add(panel);
		panel.setLayout(null);
		FlowLayout fl_panel_btn = (FlowLayout) panel_btn.getLayout();
		fl_panel_btn.setHgap(20);
		panel_btn.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_btn.setBackground(Color.WHITE);
		panel_btn.setBounds(12, 196, 436, 36);
		
		panel.add(panel_btn);
		
		panel_btn.add(ok);
		
		panel_btn.add(cancel);
		lable_IP.setBounds(12, 51, 95, 15);
		
		panel.add(lable_IP);
		label_talkName.setBounds(12, 118, 95, 15);
		
		panel.add(label_talkName);
		
		panel.add(ipTF);
		nameTF.setColumns(10);
		nameTF.setBounds(102, 115, 321, 21);
		
		panel.add(nameTF);
		setVisible(true);
	}// end Login


}
