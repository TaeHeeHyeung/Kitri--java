package ex_multichat_woojin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;

public class ReName extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;

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
		super("¥Î»≠∏Ì ∫Ø∞Ê");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 165);
		contentPane = new JPanel();
		Color backg1 = new Color(213, 170, 218);
		contentPane.setBackground(backg1);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(backg1);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Old Name :");
		lblNewLabel.setFont(new Font("±º∏≤", Font.BOLD, 12));
		lblNewLabel.setBounds(22, 11, 78, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Name :");
		lblNewLabel_1.setFont(new Font("±º∏≤", Font.BOLD, 12));
		lblNewLabel_1.setBounds(22, 46, 88, 26);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(106, 49, 149, 26);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("oldname");
		lblNewLabel_2.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(106, 16, 149, 26);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(backg1);
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBounds(53, 82, 161, 31);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 4, 0));
		
		JButton ok = new JButton("\uBCC0 \uACBD");
		panel_1.add(ok);
		
		JButton cancel = new JButton("\uCDE8 \uC18C");
		panel_1.add(cancel);
	}

}
