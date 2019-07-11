package swingtest;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.Border;

public class TestLayout extends JFrame {
	JPanel jpanel= new JPanel();
	TestLayout() {
		Border innerBorder = BorderFactory.createEmptyBorder(50, 50, 50, 50);
		Border outerBorder = BorderFactory.createLineBorder(Color.BLACK);
		
		jpanel.setBorder(BorderFactory.createCompoundBorder(innerBorder,outerBorder));
		jpanel.setPreferredSize(new Dimension(200, 50));;
		
		jpanel.add(new JTextField("asdfasdfasdfasdfsdf"));
		
		add(jpanel);
		setBounds(200, 200, 400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestLayout();
	}
}
