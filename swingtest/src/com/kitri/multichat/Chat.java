package com.kitri.multichat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;

public class Chat extends JFrame {

	private JPanel contentPane;
	private JTextArea area;
	private JList list;
	private JButton rename;
	private JButton paper;
	private JButton close;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
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
	public Chat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 304);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		area = new JTextArea();
		area.setBounds(12, 10, 345, 192);
		contentPane.add(area);
		
		JTextField textField = new JTextField();
		textField.setBounds(12, 212, 345, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel whom = new JLabel("\uADD3\uC18D\uB9D0");
		whom.setBounds(12, 243, 57, 15);
		contentPane.add(whom);
		
		JTextField whomsend = new JTextField();
		whomsend.setBounds(81, 240, 276, 21);
		contentPane.add(whomsend);
		whomsend.setColumns(10);
		
		list = new JList();
		list.setBounds(369, 13, 97, 156);
		contentPane.add(list);
		
		rename = new JButton("\uB300\uD654\uBA85\uBCC0\uACBD");
		rename.setBounds(369, 180, 97, 23);
		contentPane.add(rename);
		
		paper = new JButton("\uCABD\uC9C0\uBCF4\uB0B4\uAE30");
		paper.setBounds(369, 211, 97, 23);
		contentPane.add(paper);
		
		close = new JButton("\uB098 \uAC00 \uAE30");
		close.setBounds(369, 239, 97, 23);
		contentPane.add(close);
	}
}
