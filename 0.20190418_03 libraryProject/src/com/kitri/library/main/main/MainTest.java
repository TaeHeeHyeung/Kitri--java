package com.kitri.library.main.main;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.kitri.library.bookmng.BookMng;
import com.kitri.library.bookmng.bookinfo.BookInfo;
import com.kitri.library.controller.Controller;
import com.kitri.library.db.BookDao;
import com.kitri.library.db.BookDto;
import com.kitri.library.main.start.StartController;
import com.kitri.library.main.start.StartTest;
import com.kitri.library.member.mng.MemberMng;
import com.kitri.library.rent.Rent;
import com.kitri.library.ret.BookReturn;
//import com.kitri.library.statistic.StatisticTest;

public class MainTest extends JPanel {
	public Rent rent;
	public BookReturn pReturn;
	public BookMng pBookMng;
	public MemberMng pMemberMng;

	public JTable main_table;
	// Controller controller;

	public BookDao bookDao;
	public BookDto bookDto;

	JScrollPane scrollPane;
	public JButton btn_pLogOut;
	public JButton btn_bookSearch;
	public JButton btn_pRent;
	public JButton btn_pBookRet;
	public JButton btn_pMembers;
	public JButton btn_pBookmang;
//	public JButton btn_pStatis;
	public JTextField tf_searchBook;
//	public String[] colArr = { "도서명", "저자", "ISBN", "청구기호", "발행년도", "출판사" };
	String[][] bookContentsArr;
	String[] header = new String[] { "도서명", "저자", "ISBN", "청구기호", "발행년도", "출판사", "대여자(member_id)" };

	public MainController mainController;
	public StartTest startTest;

//	public StatisticTest statisticTest;
	public JComboBox comboSerarchBookMenu = new JComboBox(new String[] { "도서명", "저자" });

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFrame frame = new JFrame("a");
//					frame.setBounds(0, 0, 800, 800);
//					frame.getContentPane().setLayout(null);
//					frame.getContentPane().add(new Main(null));
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}// end main

	/**
	 * Create the frame.
	 */
	public MainTest(StartTest startTest) {
		bookDao = BookDao.getInstance();
		this.startTest = startTest;

//		statisticTest= new StatisticTest(this);
		rent = new Rent(this); // 메인화면 -> 대여
		pReturn = new BookReturn(this); // 메인화면 -> 반납
		pBookMng = new BookMng(this); // 메인화면 -> 도서관리화면
		pMemberMng = new MemberMng(); // 메인화면 -> 멤버관리화면

		initUI();
		tableUpdate();
		// 메인 리스너
		this.mainController = new MainController(this);

//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(75, 121, 30, 21);
//		add(comboBox);
		btn_pLogOut.addActionListener(mainController);
		btn_pRent.addActionListener(mainController);
		btn_pBookRet.addActionListener(mainController);
		btn_pMembers.addActionListener(mainController);
		btn_pBookmang.addActionListener(mainController);
//		btn_pStatis.addActionListener(mainController);
		btn_bookSearch.addActionListener(mainController);

	}

	private void initUI() {
		setBounds(new Rectangle(0, 0, 800, 1000));
		setBounds(380, 40, 800, 800);
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 800, 1000));
		setBorder(null);
		setLayout(null);
		tf_searchBook = new JTextField();
		tf_searchBook.setBorder(new LineBorder(Color.BLACK));
		tf_searchBook.setBounds(203, 117, 419, 30);
		add(tf_searchBook);
		tf_searchBook.setColumns(10);

		btn_bookSearch = new JButton("\uAC80\uC0C9");
		btn_bookSearch.setBackground(Color.LIGHT_GRAY);
		btn_bookSearch.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_bookSearch.setForeground(new Color(0, 0, 0));
		btn_bookSearch.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		btn_bookSearch.setBounds(657, 116, 76, 30);
		add(btn_bookSearch);

		btn_pRent = new JButton("\uB300\uC5EC");
		btn_pRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_pRent.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_pRent.setBackground(Color.LIGHT_GRAY);
		btn_pRent.setForeground(Color.BLACK);
		btn_pRent.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		btn_pRent.setBounds(75, 60, 93, 30);
		add(btn_pRent);

		btn_pBookRet = new JButton("\uBC18\uB0A9");
		btn_pBookRet.setBackground(Color.LIGHT_GRAY);
		btn_pBookRet.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_pBookRet.setForeground(new Color(0, 0, 0));
		btn_pBookRet.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		btn_pBookRet.setBounds(241, 60, 93, 30);
		add(btn_pBookRet);

		btn_pMembers = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		btn_pMembers.setBackground(Color.LIGHT_GRAY);
		btn_pMembers.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_pMembers.setForeground(new Color(0, 0, 0));
		btn_pMembers.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		btn_pMembers.setBounds(406, 60, 103, 30);
		add(btn_pMembers);

		btn_pBookmang = new JButton("\uB3C4\uC11C\uAD00\uB9AC");
		btn_pBookmang.setBackground(Color.LIGHT_GRAY);
		btn_pBookmang.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_pBookmang.setForeground(new Color(0, 0, 0));
		btn_pBookmang.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		btn_pBookmang.setBounds(586, 60, 103, 30);
		add(btn_pBookmang);

//		btn_pStatis = new JButton("\uD1B5\uACC4");
//		btn_pStatis.setBackground(Color.LIGHT_GRAY);
//		btn_pStatis.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
//		btn_pStatis.setForeground(new Color(0, 0, 0));
//		btn_pStatis.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
//		btn_pStatis.setBounds(666, 60, 93, 30);
//		add(btn_pStatis);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 196, 736, 537);
		add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		btn_pLogOut = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_pLogOut.setForeground(Color.BLACK);
		btn_pLogOut.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		btn_pLogOut.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_pLogOut.setBackground(Color.LIGHT_GRAY);
		btn_pLogOut.setBounds(677, 10, 76, 30);
		add(btn_pLogOut);

		// 콤보박스

		comboSerarchBookMenu.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboSerarchBookMenu.setBounds(58, 117, 110, 30);

		add(comboSerarchBookMenu);
		// ======================테이블===================
		main_table = new JTable();
		main_table.setEnabled(false);
		// 테이블 로우를 한개만 선택가능하게 한다. 이걸 사용하면 오직 한개의 로우만 선택할 수 있다.
		main_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		main_table.setBounds(12, 549, 710, 548);
		scrollPane.setViewportView(main_table);

	}// end initUi

	public void tableUpdate() {
		// 선택자체가 불가능하게한다.

		bookDao.setAllList();
		Vector<BookDto> lists = bookDao.getList();
		setTableModel(lists);
	}

	public void setTableModel(Vector<BookDto> lists) {
		int len = lists.size();

		// 출판일이 null이면 에러
		bookContentsArr = new String[len][header.length];
		for (int i = 0; i < len; i++) {
			if (lists.get(i).getIsbn().equals("01")) {
				lists.get(i).getRenting();
			}
			String[] contentsArr = new String[] { lists.get(i).getName(), lists.get(i).getWriter(),
					lists.get(i).getIsbn(), lists.get(i).getPosition(), lists.get(i).getPublish_dateStr(),
					lists.get(i).getPublisher(), lists.get(i).getRenting() };
			bookContentsArr[i] = contentsArr;
			// System.out.println(Arrays.deepToString(contentsArr));
		}
		// 갱신하려면 model을 추가해야한다.,
		DefaultTableModel model = new DefaultTableModel(bookContentsArr, header) {
			// 테이블의 값 변경을 막는다.
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		main_table.setModel(model);
	}
}// end MainClass
