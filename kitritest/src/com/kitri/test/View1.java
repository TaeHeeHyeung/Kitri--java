package com.kitri.test;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class View1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public View1() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 426, 280);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 63, 400, 197);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(12, 10, 97, 23);
		panel.add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(121, 10, 97, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(230, 10, 97, 23);
		panel.add(button_1);

	}

}
