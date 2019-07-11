package com.kitri.library.rent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.kitri.library.controller.Controller;
import com.kitri.library.db.*;
import com.kitri.library.file.ImageFile;
import com.kitri.library.main.main.MainTest;

import java.awt.Font;
import java.awt.event.*;
import java.util.*;
import java.awt.Color;

public class Rent extends JFrame {

	private JPanel contentPane;
	public JTextField tf_memId;
	public JTextField tf_bookISBN;
	public JTable table_rent;
	public JButton bt_rent;
	public JButton bt_cancel;
	public JButton bt_choice;
	public JButton bt_bookISBN;

	RentController rentController;
	public JLabel lbl_rentable;
	public RentDao rentDao;
	public BookDao bookDao;

	public static final Vector<String> HEADER_LIST = new Vector<String>(
			Arrays.asList(new String[] { "도서명", "저자", "ISBN", "청구기호", "발행년도", "대여자" }));
	public Vector<Vector<String>> contentsLists = new Vector<Vector<String>>();
	private JScrollPane scrollPane_1;
	public TableModel rowData;
	public TableColumnModel columnNames;
	public MemberDao memberDao;
	public MainTest mainTest;
	public JLabel lb_ImgMember;
	public RentControllerKey rentControllerKey;
	public ImageFile imageFile;
	public JLabel lb_tfMemberName;

	public Rent(MainTest mainTest) {
		this.mainTest = mainTest;
		imageFile = new ImageFile();
		rentDao = RentDao.getInstance();
		bookDao = BookDao.getInstance();
		memberDao = MemberDao.getInstance();
		rentController = new RentController(this);
		rentControllerKey = new RentControllerKey(this);
		uiInit();
		setLocationRelativeTo(null); // 프레임을 화면 정가운데 위치 키워드 :중앙, 가운데

		bt_rent.addActionListener(rentController);
		bt_cancel.addActionListener(rentController);
		bt_choice.addActionListener(rentController);
		bt_bookISBN.addActionListener(rentController);
		tf_memId.addKeyListener(rentControllerKey);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // 종료 막기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				rentController.rentService.close();
			}
		});
	}

	public void tfInit() {
		tf_memId.setText("");
		lb_tfMemberName.setText("");
		tf_bookISBN.setText("");
	}

	private void uiInit() {
		setTitle("\uB300\uC5EC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		label.setBounds(126, 12, 75, 28);
		contentPane.add(label);

		tf_memId = new JTextField();
		tf_memId.setColumns(10);
		tf_memId.setBounds(203, 12, 240, 28);
		contentPane.add(tf_memId);

		JLabel label_1 = new JLabel("\uD68C\uC6D0\uBA85");
		label_1.setBounds(126, 52, 75, 28);
		contentPane.add(label_1);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(126, 92, 75, 28);
		contentPane.add(lblIsbn);

		tf_bookISBN = new JTextField();
		tf_bookISBN.setColumns(10);
		tf_bookISBN.setBounds(203, 92, 153, 28);
		contentPane.add(tf_bookISBN);

		bt_bookISBN = new JButton("\uD655\uC778");
		bt_bookISBN.setFont(new Font("굴림", Font.PLAIN, 12));
		bt_bookISBN.setBounds(368, 92, 75, 27);
		contentPane.add(bt_bookISBN);

		bt_choice = new JButton("\uC120\uD0DD");
		bt_choice.setFont(new Font("굴림", Font.PLAIN, 12));
		bt_choice.setBounds(368, 133, 75, 27);
		contentPane.add(bt_choice);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 180, 429, 225);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 427, 223);
		panel.add(scrollPane_1);

		table_rent = new JTable(contentsLists, HEADER_LIST);
		// 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수 있다.
		table_rent.getTableHeader().setReorderingAllowed(false);
		// 테이블 컬럼의 사이즈를 고정시킨다. 이걸 사용하면 컬럼 사이즈가 변하지 않는다.
		table_rent.getTableHeader().setResizingAllowed(false);
		// 테이블 로우를 한개만 선택가능하게 한다. 이걸 사용하면 오직 한개의 로우만 선택할 수 있다.
		table_rent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table_rent);

		bt_rent = new JButton("\uB300\uC5EC");
		bt_rent.setFont(new Font("굴림", Font.PLAIN, 12));
		bt_rent.setBounds(273, 421, 75, 27);
		contentPane.add(bt_rent);

		bt_cancel = new JButton("\uCDE8\uC18C");
		bt_cancel.setFont(new Font("굴림", Font.PLAIN, 12));
		bt_cancel.setBounds(368, 421, 75, 27);
		contentPane.add(bt_cancel);

		lbl_rentable = new JLabel("\uB300\uC5EC\uC0C1\uD0DC");
		lbl_rentable.setBounds(126, 130, 230, 28);
		contentPane.add(lbl_rentable);

		lb_ImgMember = new JLabel("");
		lb_ImgMember.setBounds(14, 19, 100, 127);
		lb_ImgMember.setBackground(Color.WHITE);
		lb_ImgMember.setOpaque(true);
		contentPane.add(lb_ImgMember);

		lb_tfMemberName = new JLabel("\uD68C\uC6D0\uBA85");
		lb_tfMemberName.setBounds(203, 59, 240, 15);
		contentPane.add(lb_tfMemberName);
	}
}
