package com.kitri.test;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class view1 extends JPanel {
	private JPasswordField pwdPassword;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public view1() {
		setBounds(new Rectangle(0, 0, 479, 344));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 13, 448, 313);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(16, 83, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(220, 84, 97, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(326, 84, 97, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(115, 83, 97, 23);
		panel.add(btnNewButton_3);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("PassWord");
		pwdPassword.setBounds(131, 240, 160, 50);
		panel.add(pwdPassword);
		
		JLabel lblNewLabel = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 241, 87, 48);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setText("\uC544\uC774\uB514");
		textField.setBounds(128, 185, 161, 44);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setBounds(40, 186, 66, 32);
		panel.add(lblNewLabel_1);

	}
}
