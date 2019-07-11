package com.kitri.library.bookmng.bookadd;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.library.bookmng.BookMng;
import com.kitri.library.db.BookDao;
import com.kitri.library.db.BookDto;

import java.awt.*;
import java.awt.event.*;

public class BookAdd extends JFrame {

	public JButton btImg;
	public BookMng pBookMng;
	public BookDao bookDao;
	public BookDto bookDto;
	private JPanel contentPane;
	public JTextField tfBookName;
	public JTextField tfAuthor;
	public JTextField tfIsbn;
	public JTextField tfBookPub;
	public JTextField tfPubDate;
	public JTextField tfCall;
	public JTextField tfGenre;
	public JLabel lbImg;
	public JButton btOk;

	public java.sql.Date sqlDate;
	public final String PUBLISH_DATE_STR = "'2019-04-21'형식으로 넣어주세요";
	BookAddController bookAddController;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// BookAdd frame = new BookAdd(null);
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }
	// public MainTest pMainTest;

	/**
	 * Create the frame.
	 */
	public BookAdd(BookMng pBookMng) {
		this.pBookMng = pBookMng;

		bookAddController = new BookAddController(this);
		uiInit();

		// 순차 종료 막기WindowListener
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// 리스너등록
		btOk.addActionListener(bookAddController);
		btImg.addActionListener(bookAddController);
		addWindowListener(bookAddController);

		// 퍼블리쉬데이트 글씨 제거
		tfPubDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfPubDate.setText("");
			}
		});
	}

	public void uiInit() {
		setTitle("\uB3C4\uC11C\uCD94\uAC00");
		bookDao = BookDao.getInstance();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 425, 365);
		setLocationRelativeTo(null); // 프레임을 화면 정가운데 위치
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbBookname = new JLabel("\uB3C4\uC11C\uBA85");
		lbBookname.setBounds(126, 10, 75, 28);
		contentPane.add(lbBookname);

		tfBookName = new JTextField();
		tfBookName.setColumns(10);
		tfBookName.setBounds(203, 12, 192, 28);
		contentPane.add(tfBookName);

		JLabel lbAuthor = new JLabel("\uC800\uC790");
		lbAuthor.setBounds(126, 50, 75, 28);
		contentPane.add(lbAuthor);

		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(203, 52, 192, 28);
		contentPane.add(tfAuthor);

		JLabel lbIsbn = new JLabel("ISBN");
		lbIsbn.setBounds(126, 90, 75, 28);
		contentPane.add(lbIsbn);

		tfIsbn = new JTextField();
		tfIsbn.setColumns(10);
		tfIsbn.setBounds(203, 92, 192, 28);
		contentPane.add(tfIsbn);

		JLabel lbBookPub = new JLabel("\uCD9C\uD310\uC0AC");
		lbBookPub.setBounds(126, 130, 75, 28);
		contentPane.add(lbBookPub);

		tfBookPub = new JTextField();
		tfBookPub.setColumns(10);
		tfBookPub.setBounds(203, 132, 192, 28);
		contentPane.add(tfBookPub);

		JLabel lbPubDate = new JLabel("\uCD9C\uAC04\uC77C");
		lbPubDate.setBounds(126, 170, 75, 28);
		contentPane.add(lbPubDate);

		tfPubDate = new JTextField();
		tfPubDate.setText(PUBLISH_DATE_STR);
		tfPubDate.setColumns(10);
		tfPubDate.setBounds(203, 172, 192, 28);
		contentPane.add(tfPubDate);

		JLabel lbCall = new JLabel("\uCCAD\uAD6C\uAE30\uD638");
		lbCall.setBounds(126, 210, 75, 28);
		contentPane.add(lbCall);

		tfCall = new JTextField();
		tfCall.setColumns(10);
		tfCall.setBounds(203, 212, 192, 28);
		contentPane.add(tfCall);

		btOk = new JButton("\uD655\uC778");
		btOk.setFont(new Font("굴림", Font.PLAIN, 12));
		btOk.setBounds(337, 290, 60, 27);
		contentPane.add(btOk);

		JLabel lbGenre = new JLabel("\uC7A5\uB974");
		lbGenre.setBounds(126, 250, 75, 28);
		contentPane.add(lbGenre);

		tfGenre = new JTextField();
		tfGenre.setColumns(10);
		tfGenre.setBounds(203, 252, 192, 28);
		contentPane.add(tfGenre);

		btImg = new JButton("\uC774\uBBF8\uC9C0\uCD94\uAC00");
		btImg.setBounds(10, 144, 104, 23);
		contentPane.add(btImg);

		lbImg = new JLabel("");

		lbImg.setBounds(12, 17, 102, 117);
		lbImg.setBackground(Color.WHITE);
		lbImg.setOpaque(true);
		contentPane.add(lbImg);
	}

	public void initContent(String str) {
		tfBookName.setText(str);
		tfAuthor.setText(str);
		tfIsbn.setText(str);
		tfBookPub.setText(str);
		tfPubDate.setText(PUBLISH_DATE_STR);
		tfCall.setText(str);
		tfGenre.setText(str);
	}
}
