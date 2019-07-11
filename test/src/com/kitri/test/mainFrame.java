package com.kitri.test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class mainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton b1;
	private JButton b2;
	JPanel panel;
	
	view1 v1 = new view1();
	view2 v2 = new view2();
	
	CardLayout card = new CardLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
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
	public mainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(card);
		panel.add("view1", v1); // add(string , ) 화면에 이름을 붙이는 것임.
		panel.add("view2", v2);
		card.show(panel, "view2");
		panel.setBounds(17, 60, 479, 344);
		contentPane.add(panel);
		
		b1 = new JButton("\uD654\uBA741");
		b1.setBounds(15, 19, 105, 30);
		contentPane.add(b1);
		
		b2 = new JButton("\uD654\uBA742");
		b2.setBounds(140, 15, 103, 33);
		contentPane.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == b1) {
			card.show(panel, "view1");
		}else if(ob == b2) {
			card.show(panel, "view2");
		}
		
	}

}
