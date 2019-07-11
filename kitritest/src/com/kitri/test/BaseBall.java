package com.kitri.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class BaseBall extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseBall frame = new BaseBall();
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
	public BaseBall() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 358, 244);
		contentPane.add(scrollPane);
		
		JLabel label = new JLabel("\uC785\uB825");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 264, 75, 22);
		contentPane.add(label);
		
		tf = new JTextField();
		tf.setBounds(95, 265, 275, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(382, 10, 109, 276);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 1, 10, 10));
		
		JButton newG = new JButton("\uC0C8\uAC8C\uC784");
		newG.setBorder(new LineBorder(new Color(0, 0, 0)));
		newG.setBackground(Color.GRAY);
		panel.add(newG);
		
		JButton clear = new JButton("\uC9C0\uC6B0\uAE30");
		panel.add(clear);
		
		JButton button_1 = new JButton("\uC815\uB2F5");
		panel.add(button_1);
		
		JButton button_2 = new JButton("\uAE00\uC790\uC0C9");
		panel.add(button_2);
		
		JButton button_3 = new JButton("\uC885\uB8CC");
		panel.add(button_3);
	}
}
