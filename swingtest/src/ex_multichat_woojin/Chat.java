package ex_multichat_woojin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Chat extends JFrame {

	private JPanel contentPane;
	private JTextField globalsend;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
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
	public Chat() {
		super("Αρ°ΕΏξ Γ€ΖΓ.. ^^*");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 449);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 342, 302);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(366, 10, 104, 264);
		panel.add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		
		JButton rename = new JButton("\uB300\uD654\uBA85\uBCC0\uACBD");
		rename.setBounds(362, 285, 108, 31);
		panel.add(rename);
		
		JButton paper = new JButton("\uCABD\uC9C0\uBCF4\uB0B4\uAE30");
		paper.setBounds(362, 323, 108, 31);
		panel.add(paper);
		
		JButton close = new JButton("\uB098 \uAC00 \uAE30");
		close.setBounds(362, 360, 108, 31);
		panel.add(close);
		
		globalsend = new JTextField();
		globalsend.setBounds(12, 328, 338, 31);
		panel.add(globalsend);
		globalsend.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(84, 365, 266, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uADD3\uC18D\uB9D0");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(15, 368, 57, 23);
		panel.add(lblNewLabel);
	}
}
