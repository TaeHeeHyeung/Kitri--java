package swingtest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ComboBox extends JFrame {

	private JPanel contentPane;
	final ComboBoxModel<String> comboBoxmodel;
	Vector<String> vlist;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBox frame = new ComboBox();
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
	public ComboBox() {
		vlist = new Vector<String>();
		vlist.add("10");
		vlist.add("20");
		vlist.add("30");
		comboBoxmodel= new DefaultComboBoxModel<String>(vlist);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JComboBox comboBox = new JComboBox();
		menuBar.add(comboBox);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}

}
