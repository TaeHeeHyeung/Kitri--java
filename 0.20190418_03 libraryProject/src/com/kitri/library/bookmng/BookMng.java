package com.kitri.library.bookmng;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.kitri.library.bookmng.bookadd.BookAdd;
import com.kitri.library.bookmng.bookinfo.BookInfo;
import com.kitri.library.controller.Controller;
import com.kitri.library.db.BookDao;
import com.kitri.library.db.BookDto;
import com.kitri.library.file.ImageFile;
import com.kitri.library.main.main.MainTest;
import com.kitri.test.swing.Main;

public class BookMng extends JFrame {

	public JPanel contentPane;
	public JTextField tfSearch;
	public JButton btnSearch;
	public JButton btnAdd;
	public JButton btnDelete;
	public JButton btnCancel;
	public JPanel panel;
	public JScrollPane scrollPane;
	public JTable book_table;

	public JComboBox comboBoxMenu;
	public BookDao bookDao;
	public JButton btn_Update;
	public final static String COL_TABLE_ARR[] = { "������", "����", "ISBN", "û����ȣ", "����⵵", "���ǻ�" };
	public final static String COMBO_MENU_ARR[] = { "������", "����", "ISBN", "û����ȣ", "����⵵", "���ǻ�" };

	BookMngController bookMngController;
	BookAdd pBookAdd;
	BookInfo bookInfo;

	public MainTest pMain;
	public ImageFile imageFile;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMng frame = new BookMng(null);
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
	public BookMng(MainTest pMain) {
		this.pMain = pMain;
		imageFile = new ImageFile();
		uiInit();
		tableInit();

		pBookAdd = new BookAdd(this);
		bookInfo = new BookInfo(this);

		// ������ �߰�
		bookMngController = new BookMngController(this);

		btnAdd.addActionListener(bookMngController);
		btnDelete.addActionListener(bookMngController);
		btnCancel.addActionListener(bookMngController);
		btn_Update.addActionListener(bookMngController);
		btnSearch.addActionListener(bookMngController);

		// �����ư Window������
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // ���� ����
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				bookMngController.bookMngService.pBookClose();
			}
		});

	}// end BookMng

	// UI �ʱ�ȭ
	public void uiInit() {
		setTitle("\uB3C4\uC11C\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 680, 430);
		setLocationRelativeTo(null); // �������� ȭ�� ����� ��ġ
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBoxMenu = new JComboBox(COMBO_MENU_ARR);
		comboBoxMenu.setModel(new DefaultComboBoxModel(new String[] {"\uB3C4\uC11C\uBA85", "\uC800\uC790"}));

		comboBoxMenu.setBounds(14, 12, 127, 24);
		contentPane.add(comboBoxMenu);

		tfSearch = new JTextField();
		tfSearch.setBounds(154, 12, 385, 24);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);

		btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setBounds(552, 11, 105, 27);
		contentPane.add(btnSearch);

		btnAdd = new JButton("\uCD94\uAC00");
		btnAdd.setBounds(14, 352, 97, 23);
		contentPane.add(btnAdd);

		btnDelete = new JButton("\uC0AD\uC81C");
		btnDelete.setBounds(133, 352, 97, 23);
		contentPane.add(btnDelete);

		btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.setBounds(552, 352, 97, 23);
		contentPane.add(btnCancel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 48, 640, 290);
		contentPane.add(scrollPane);
		// ��ư
		btn_Update = new JButton("\uB3C4\uC11C\uC815\uBCF4\uBCC0\uACBD");
		btn_Update.setBounds(242, 352, 121, 23);
		contentPane.add(btn_Update);
	}

	// ���̺� �ʱⰪ ����
	private void tableInit() {
		// ======================���̺�===================
		Object[][] bookContentsArr;
		Object[] header;
		header = new String[] { "������", "����", "ISBN", "û����ȣ", "����⵵", "���ǻ�" };
		int len = header.length;
		bookDao = BookDao.getInstance();
		List<BookDto> lists = bookDao.getList();
		len = lists.size();
		bookContentsArr = new String[len][header.length];
		for (int i = 0; i < len; i++) {
			String[] contentsArr = { lists.get(i).getName(), lists.get(i).getWriter(), lists.get(i).getIsbn(),
					lists.get(i).getPosition(), lists.get(i).getPublish_dateStr(), lists.get(i).getPublisher() };
			bookContentsArr[i] = contentsArr;
			// System.out.println(Arrays.deepToString(contentsArr));
		}

		// ���̺��� �� ������ ���´�.
		book_table = new JTable(bookContentsArr, header) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// ���̺� �ο츦 �Ѱ��� ���ð����ϰ� �Ѵ�. �̰� ����ϸ� ���� �Ѱ��� �ο츸 ������ �� �ִ�.
		book_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		book_table.setBounds(12, 549, 710, 548);
		scrollPane.setViewportView(book_table);
	}

	// ���̺� �� ����
	public void tableModelUpdate() {
		bookDao.setAllList();
		Vector<BookDto> list = bookDao.getList();
		Vector<Vector<String>> vecList = new Vector<Vector<String>>();
		int len = list.size();
		for (int i = 0; i < len; i++) {
			Vector<String> vec = new Vector<String>();
			vec.add(list.get(i).getName());
			vec.add(list.get(i).getWriter());
			vec.add(list.get(i).getIsbn());
			vec.add(list.get(i).getPosition());
			vec.add(list.get(i).getPublish_dateStr());
			vec.add(list.get(i).getPublisher());
			vecList.add(vec);
		}
		Vector<String> colVec = new Vector<String>();
		len = COL_TABLE_ARR.length;
		for (int i = 0; i < len; i++) {
			colVec.add(COL_TABLE_ARR[i]);
		}
		// �����Ϸ��� model�� �߰��ؾ��Ѵ�.
		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
		book_table.setModel(model);
	}// end tableModelUpdate

}// end class BookMng
