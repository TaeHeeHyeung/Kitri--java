package com.kitri.multichat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReName extends JFrame {

	private JPanel contentPane;
	private JTextField newname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReName frame = new ReName();
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
	public ReName() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 410, 242);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Old Name :");
		lblNewLabel.setBounds(43, 55, 92, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewName = new JLabel("New Name:");
		lblNewName.setBounds(43, 133, 92, 45);
		panel.add(lblNewName);
		
		newname = new JTextField();
		newname.setColumns(10);
		newname.setBounds(172, 145, 116, 21);
		panel.add(newname);
		
		JButton ok = new JButton("\uBCC0\uACBD");
		ok.setBounds(111, 209, 97, 23);
		panel.add(ok);
		
		JButton cancel = new JButton("\uCDE8\uC18C");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancel.setBounds(220, 209, 97, 23);
		panel.add(cancel);
	}

}
