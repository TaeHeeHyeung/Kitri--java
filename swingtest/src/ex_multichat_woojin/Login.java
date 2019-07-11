package ex_multichat_woojin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField ipTF;
	private JTextField nameTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login!!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 165);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   I   P :");
		lblNewLabel.setBounds(22, 11, 57, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB300\uD654\uBA85 :");
		lblNewLabel_1.setBounds(22, 46, 57, 26);
		panel.add(lblNewLabel_1);
		
		ipTF = new JTextField();
		ipTF.setBounds(81, 13, 174, 26);
		panel.add(ipTF);
		ipTF.setColumns(10);
		
		nameTF = new JTextField();
		nameTF.setBounds(81, 47, 174, 26);
		panel.add(nameTF);
		nameTF.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		panel_1.setBounds(12, 81, 245, 32);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton ok = new JButton("\uD655 \uC778");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ok.setBounds(47, 5, 61, 23);
		panel_1.add(ok);
		
		JButton cancel = new JButton("\uCDE8 \uC18C");
		cancel.setBounds(134, 5, 61, 23);
		panel_1.add(cancel);
	}

}
