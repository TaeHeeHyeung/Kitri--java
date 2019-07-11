package com.kitri.library.bookmng.bookinfo;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.library.bookmng.BookMng;
import com.kitri.library.controller.Controller;
import com.kitri.library.db.BookDao;
import com.kitri.library.db.BookDto;
import com.kitri.library.main.main.MainTest;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.CardLayout;
import java.awt.Color;

public class BookInfoBackup extends JFrame {

	public BookDao bookDao;
	public BookDto bookDto;

	public JPanel contentPane;
	public JTextField tfBookName;
	public JTextField tfBookWriter;
	public JTextField tfISBN;
	public JTextField tfBookPublisher;
	public JTextField tfBookPublishDate;
	public JTextField tfBookPosition;
	public JButton btn_close;
	public JButton btn_editConfirm;
	public JButton btn_edit;

	public JPanel panel_cardLayout;
	public CardLayout cardLayout;

//	BookInfoController bookInfoController;
	public BookMng pBookMng;
	public MainTest pMainTest;
	public JButton bt_img;
	public JLabel lb_img;
	public String imagePathStr;
	public JLabel lb_RentingYN;
	public JLabel lb_RentMem;
	public JLabel lbReturnDate;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookInfo frame = new BookInfo(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public BookInfoBackup(BookMng pBookMng) {
		bookDao = BookDao.getInstance();
		this.pBookMng = pBookMng;
		this.pMainTest = pBookMng.pMain;

//		bookInfoController = new BookInfoController(this);

		// 유아이 초기화
		initUI();

		// 리스너 등록
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // 종료 막기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
//				bookInfoController.bookInfoService.close();
			}
		});
//
//		bt_img.addActionListener(bookInfoController);
//		btn_close.addActionListener(bookInfoController);
//		btn_edit.addActionListener(bookInfoController);
//		btn_editConfirm.addActionListener(bookInfoController);
	}// end BookInfo

	private void initUI() {
		setTitle("\uB3C4\uC11C\uC0C1\uC138\uC815\uBCF4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uB3C4\uC11C\uBA85");
		lblNewLabel_1.setBounds(126, 10, 75, 28);
		contentPane.add(lblNewLabel_1);

		tfBookName = new JTextField();
		tfBookName.setEditable(false);
		tfBookName.setBounds(203, 12, 192, 28);
		contentPane.add(tfBookName);
		tfBookName.setColumns(10);

		JLabel label = new JLabel("\uC800\uC790");
		label.setBounds(126, 50, 75, 28);
		contentPane.add(label);

		tfBookWriter = new JTextField();
		tfBookWriter.setEditable(false);
		tfBookWriter.setColumns(10);
		tfBookWriter.setBounds(203, 52, 192, 28);
		contentPane.add(tfBookWriter);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(126, 90, 75, 28);
		contentPane.add(lblIsbn);

		tfISBN = new JTextField();
		tfISBN.setEditable(false);
		tfISBN.setColumns(10);
		tfISBN.setBounds(203, 92, 192, 28);
		contentPane.add(tfISBN);

		JLabel label_2 = new JLabel("\uCD9C\uD310\uC0AC");
		label_2.setBounds(126, 130, 75, 28);
		contentPane.add(label_2);

		tfBookPublisher = new JTextField();
		tfBookPublisher.setEditable(false);
		tfBookPublisher.setColumns(10);
		tfBookPublisher.setBounds(203, 132, 192, 28);
		contentPane.add(tfBookPublisher);

		JLabel label_3 = new JLabel("\uCD9C\uAC04\uC77C");
		label_3.setBounds(126, 170, 75, 28);
		contentPane.add(label_3);

		tfBookPublishDate = new JTextField();
		tfBookPublishDate.setEditable(false);
		tfBookPublishDate.setColumns(10);
		tfBookPublishDate.setBounds(203, 172, 192, 28);
		contentPane.add(tfBookPublishDate);

		JLabel label_4 = new JLabel("\uCCAD\uAD6C\uAE30\uD638");
		label_4.setBounds(126, 212, 75, 28);
		contentPane.add(label_4);

		tfBookPosition = new JTextField();
		tfBookPosition.setEditable(false);
		tfBookPosition.setColumns(10);
		tfBookPosition.setBounds(203, 212, 192, 28);
		contentPane.add(tfBookPosition);

		JLabel lbRYN = new JLabel("\uB300\uC5EC\uC5EC\uBD80");
		lbRYN.setFont(new Font("굴림", Font.PLAIN, 12));
		lbRYN.setBounds(126, 277, 62, 18);
		contentPane.add(lbRYN);

		JLabel lbRM = new JLabel("\uB300\uC5EC\uC790");
		lbRM.setFont(new Font("굴림", Font.PLAIN, 12));
		lbRM.setBounds(126, 305, 62, 18);
		contentPane.add(lbRM);

		JLabel lbRD = new JLabel("\uBC18\uB0A9\uC608\uC815\uC77C");
		lbRD.setFont(new Font("굴림", Font.PLAIN, 12));
		lbRD.setBounds(126, 333, 62, 18);
		contentPane.add(lbRD);

		lb_RentingYN = new JLabel("");
		lb_RentingYN.setFont(new Font("굴림", Font.PLAIN, 12));
		lb_RentingYN.setBounds(203, 277, 192, 18);
		contentPane.add(lb_RentingYN);

		lb_RentMem = new JLabel("");
		lb_RentMem.setFont(new Font("굴림", Font.PLAIN, 12));
		lb_RentMem.setBounds(203, 305, 192, 18);
		contentPane.add(lb_RentMem);

		lbReturnDate = new JLabel("");
		lbReturnDate.setFont(new Font("굴림", Font.PLAIN, 12));
		lbReturnDate.setBounds(203, 333, 192, 18);
		contentPane.add(lbReturnDate);

		btn_close = new JButton("\uD655\uC778");
		btn_close.setFont(new Font("굴림", Font.PLAIN, 12));
		btn_close.setBounds(307, 374, 79, 27);
		contentPane.add(btn_close);

		// 도서 상세정보 불러와 입력하기
		tfBookName.setText("");
		tfBookWriter.setText("");
		tfISBN.setText("");
		tfBookPublisher.setText("");
		tfBookPublishDate.setText("");
		tfBookPosition.setText("");

		btn_edit = new JButton("\uBCC0\uACBD\uD558\uAE30");
		btn_edit.setBounds(0, 0, 113, 27);
		btn_edit.setFont(new Font("굴림", Font.PLAIN, 12));
		btn_editConfirm = new JButton("\uBCC0\uACBD\uC644\uB8CC");
		btn_editConfirm.setBounds(0, 0, 113, 27);

		// 카드레이아웃 생성
		cardLayout = new CardLayout();

		panel_cardLayout = new JPanel(cardLayout);
		panel_cardLayout.setBounds(182, 374, 113, 27);
		panel_cardLayout.add(btn_edit, "btn_edit");
		panel_cardLayout.add(btn_editConfirm, "btn_editConfirm");
		contentPane.add(panel_cardLayout);

		bt_img = new JButton("\uC774\uBBF8\uC9C0 \uBCC0\uACBD");
		bt_img.setBounds(12, 146, 97, 23);
		contentPane.add(bt_img);

		lb_img = new JLabel("");
		lb_img.setBackground(Color.WHITE);
		lb_img.setBounds(14, 10, 95, 126);
		lb_img.setOpaque(true);
		contentPane.add(lb_img);
	}

	public void setBookDto(BookDto bookDto) {
		this.bookDto = bookDto;
		setTF(bookDto);
	}

	public void setEditable(boolean b) {
		tfBookName.setEditable(b);
		tfBookPosition.setEditable(b);
		tfBookPublishDate.setEditable(b);
		tfBookPublisher.setEditable(b);
		tfBookWriter.setEditable(b);
		tfISBN.setEditable(b);
//		tfImgPath.setEditable(b);
	}

	public void setTF(BookDto book) {
		tfBookName.setText(book.getName());
		tfBookPosition.setText(book.getPosition());
		tfBookPublishDate.setText(book.getPublish_dateStr());
		tfBookPublisher.setText(book.getPublisher());
		tfBookWriter.setText(book.getWriter());
		tfISBN.setText(book.getIsbn());
//		tfImgPath.setText(book.getImage_path());
	}
}// end class BookInfo
