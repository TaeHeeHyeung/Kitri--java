package ex_multichat_woojin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.JButton;

public class Paper extends JFrame {

	private JPanel contentPane;
	private JTextField txtFrom;
	private JTextField txtTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paper frame = new Paper();
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
	public Paper() {
		super("ÂÊÁöº¸³»±â~~~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 307);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.YELLOW);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("From : ");
		lblNewLabel.setBounds(12, 10, 41, 23);
		panel.add(lblNewLabel);
		
		JLabel lblTo = new JLabel("To :");
		lblTo.setBounds(155, 10, 30, 23);
		panel.add(lblTo);
		
		txtFrom = new JTextField();
		txtFrom.setFont(new Font("±¼¸²", Font.BOLD, 12));
		txtFrom.setHorizontalAlignment(SwingConstants.CENTER);
		txtFrom.setText("from");
		txtFrom.setBackground(Color.ORANGE);
		txtFrom.setBounds(55, 10, 84, 23);
		panel.add(txtFrom);
		txtFrom.setColumns(10);
		
		txtTo = new JTextField();
		txtTo.setFont(new Font("±¼¸²", Font.BOLD, 12));
		txtTo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTo.setText("to");
		txtTo.setColumns(10);
		txtTo.setBackground(Color.ORANGE);
		txtTo.setBounds(186, 11, 84, 22);
		panel.add(txtTo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 43, 258, 168);
		panel.add(scrollPane);
		
		JTextArea letter = new JTextArea();
		scrollPane.setViewportView(letter);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(55, 223, 84, 26);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JButton answer = new JButton("\uB2F5 \uBCC0");
		panel_1.add(answer, "name_37556825541355");
		JButton send = new JButton("\uBCF4\uB0B4\uAE30");
		panel_1.add(send, "name_37548857853655");
		
		
		JButton cancel = new JButton("\uCDE8 \uC18C");
		cancel.setBounds(155, 223, 84, 26);
		panel.add(cancel);
	}

}
