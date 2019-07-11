package com.kitri.library.statistic;
/*
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.library.main.main.MainTest;

import java.awt.Color;

public class StatisticTest extends JFrame implements ActionListener{

	private JPanel contentPane;
	private MainTest mainTest;
	Chart chartTest;
	private JLabel lbelStatistic;
	public JButton bt_confirm;

	*//**
	 * Launch the application.
	 *//*
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StatisticTest frame = new StatisticTest();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	*//**
	 * Create the frame.
	 * 
	 * @param mainTest
	 *//*
	public StatisticTest(MainTest mainTest) {
		this.mainTest = mainTest;
		uiInit();

		chartTest = new Chart();
		chartTest.setToLabel(lbelStatistic);

		// 순차 종료 막기WindowListener
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		bt_confirm.addActionListener(this);
	}

	private void uiInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 300);
		setLocationRelativeTo(null); // 프레임을 화면 정가운데 위치 키워드 :중앙, 가운데
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		bt_confirm = new JButton("\uD655\uC778");
		bt_confirm.setBounds(278, 229, 97, 23);
		contentPane.add(bt_confirm);
		
		lbelStatistic = new JLabel("");
		lbelStatistic.setBackground(Color.WHITE);
		lbelStatistic.setBounds(52, 40, 323, 167);
		lbelStatistic.setOpaque(true);
		contentPane.add(lbelStatistic);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}*/
