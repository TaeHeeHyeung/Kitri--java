package com.kitri.test;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTable;

public class View2 extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public View2() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 5, 426, 285);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(20,5);
		scrollPane.setViewportView(table);

	}
}
