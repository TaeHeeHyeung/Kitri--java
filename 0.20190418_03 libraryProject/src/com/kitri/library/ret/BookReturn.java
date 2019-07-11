package com.kitri.library.ret;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.kitri.library.bookmng.bookadd.BookAddController;
import com.kitri.library.controller.Controller;
import com.kitri.library.db.BookDao;
import com.kitri.library.db.BookDto;
import com.kitri.library.main.main.MainTest;

import java.awt.Font;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Vector;

public class BookReturn extends JFrame {
	public BookRetController bookReturnController;
	public JPanel contentPane;
	public JTextField tf_isbn;
	public JTable table;

	public JButton bt_confirm;
	public JButton bt_addList;

	public BookDao bookDao;

	public static final Vector<String> HEADER_LIST = new Vector<String>(
			Arrays.asList(new String[] { "도서명", "저자", "ISBN", "청구기호", "대여일", "대여자" }));

	public Vector<Vector<String>> contentsVec;
	public MainTest mainTest;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// BookRet frame = new BookRet(null);
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }
	/**
	 * Create the frame.
	 */
	public BookReturn(MainTest mainTest) {
		this.mainTest = mainTest;
		bookDao = BookDao.getInstance();
		bookReturnController = new BookRetController(this);

		uiInit();
		setLocationRelativeTo(null); // 프레임을 화면 정가운데 위치 키워드 :중앙, 가운데
		bt_confirm.addActionListener(bookReturnController);
		bt_addList.addActionListener(bookReturnController);

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // 종료 막기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				bookReturnController.bookRetService.close();
			}
		});
	}

	private void uiInit() {
		setTitle("\uBC18\uB0A9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\uB3C4\uC11C\uBC88\uD638");
		label.setBounds(14, 12, 75, 28);
		contentPane.add(label);

		tf_isbn = new JTextField();
		tf_isbn.setColumns(10);
		tf_isbn.setBounds(91, 12, 240, 28);
		contentPane.add(tf_isbn);

		bt_addList = new JButton("\uD655\uC778");
		bt_addList.setFont(new Font("굴림", Font.PLAIN, 12));
		bt_addList.setBounds(345, 13, 77, 27);
		contentPane.add(bt_addList);

		bt_confirm = new JButton("\uBC18\uB0A9");
		bt_confirm.setFont(new Font("굴림", Font.PLAIN, 12));
		bt_confirm.setBounds(168, 325, 96, 27);
		contentPane.add(bt_confirm);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 52, 408, 263);
		contentPane.add(scrollPane);

		table = new JTable();
		tableInit();
		scrollPane.setViewportView(table);
	}// end initUi

	public void tableInit() {
		contentsVec = new Vector<>();
		DefaultTableModel model = new DefaultTableModel(contentsVec, HEADER_LIST);
		table.setModel(model);
	}

	public void tfInit() {
		tf_isbn.setText("");
	}

}
