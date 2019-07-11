package com.kitri.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class MainFrame extends JFrame implements ActionListener {

	JPanel panel;
	JButton btn1;
	JButton btn2;

	View1 v1 = new View1();
	View2 v2 = new View2();

	CardLayout card = new CardLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setLayout(card);
		panel.add("view2",v2);
		panel.add("view1",v1);
		

		
		panel.setBounds(12, 45, 560, 400);
		contentPane.add(panel);
		

		btn1 = new JButton("\uD654\uBA741");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn1.setBounds(12, 12, 97, 23);
		contentPane.add(btn1);

		btn2 = new JButton("\uD654\uBA742");
		btn2.setBounds(121, 12, 97, 23);
		contentPane.add(btn2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn1) {
			card.show(panel, "view1");
			
		}else if(obj == btn2) {
			card.show(panel, "view2");
		}
	}

}
