package com.kitri.multichat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.CardLayout;

public class Paper extends JFrame {

	private JPanel contentPane;
	private JTextField from;
	private JTextField to;
	//cardLayout answer 이름명
	//send => "send"

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paper frame = new Paper();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Paper() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(12, 10, 410, 242);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("From : ");
		lblNewLabel.setBounds(25, 13, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblTo = new JLabel("To : ");
		lblTo.setBounds(215, 13, 57, 15);
		panel.add(lblTo);
		
		from = new JTextField();
		from.setBackground(Color.ORANGE);
		from.setBounds(74, 10, 116, 21);
		panel.add(from);
		from.setColumns(10);
		
		to = new JTextField();
		to.setBackground(Color.ORANGE);
		to.setColumns(10);
		to.setBounds(243, 10, 116, 21);
		panel.add(to);
		
		JTextArea letter = new JTextArea();
		letter.setBounds(25, 38, 348, 163);
		panel.add(letter);
		
		JButton cancel = new JButton("취소");
		cancel.setBounds(229, 211, 97, 23);
		panel.add(cancel);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(106, 211, 97, 21);
		panel.add(panelBtn);
		panelBtn.setLayout(new CardLayout(0, 0));
		
		JButton send = new JButton("보내기");
		panelBtn.add(send, "name_38823775721806");
		
		JButton btnNewButton = new JButton("\uB2F5\uBCC0");
		panelBtn.add(btnNewButton, "name_38829542870586");
	}
}
