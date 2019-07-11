package com.kitri.library.member.info;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.kitri.library.db.*;
import com.kitri.library.file.ImageFile;
import com.kitri.library.member.mng.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Memberinfo extends JFrame {

	public static final String BT_MODIFY = "btModify";
	public static final String BT_CONFIRM = "btConfirm";
	private JPanel contentPane;
	public JTextField tfMember_id;
	public JTextField tfName;
	public JTextField tfDate;
	public JTextField tfPhone;
	public JTextField tfGender;
	public JTable table;

	public JButton btImg;
	public JButton btModify;
	public JButton btOk;

	public MemberInfoController memInfoController;
	public MemberMng memberMng;
	public ImageFile imageFile;
	public JLabel lbImg;
	public MemberDto memberDto;
	public JButton btConfirm;
	public JPanel panelCard;
	public CardLayout cardlayout;
	private Vector<String> columnNames;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Memberinfo frame = new Memberinfo();
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
	public Memberinfo(MemberMng memberMng) {
		this.memberMng = memberMng;
		this.imageFile = new ImageFile();
		this.memInfoController = new MemberInfoController(this);

		uiInit();
		setLocationRelativeTo(null); // 프레임을 화면 정가운데 위치 키워드 :중앙, 가운데

		// 리스너등록
		btImg.addActionListener(memInfoController);
		btModify.addActionListener(memInfoController);
		btConfirm.addActionListener(memInfoController);
		btOk.addActionListener(memInfoController);

		// 순차 종료 막기WindowListener
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				memInfoController.memInfoService.close();
			}

		});
	}

	private void uiInit() {
		setTitle("\uD68C\uC6D0\uC0C1\uC138\uC815\uBCF4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 425, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		label.setBounds(126, 10, 75, 28);
		contentPane.add(label);

		tfMember_id = new JTextField();
		tfMember_id.setColumns(10);
		tfMember_id.setBounds(203, 10, 192, 28);
		contentPane.add(tfMember_id);

		JLabel label_1 = new JLabel("\uC774\uB984");
		label_1.setBounds(126, 50, 75, 28);
		contentPane.add(label_1);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(203, 50, 192, 28);
		contentPane.add(tfName);

		JLabel label_2 = new JLabel("\uB098\uC774");
		label_2.setBounds(126, 90, 75, 28);
		contentPane.add(label_2);

		tfDate = new JTextField();
		tfDate.setColumns(10);
		tfDate.setBounds(203, 90, 192, 28);
		contentPane.add(tfDate);

		JLabel label_3 = new JLabel("\uC131\uBCC4");
		label_3.setBounds(126, 130, 75, 28);
		contentPane.add(label_3);

		tfGender = new JTextField();
		tfGender.setColumns(10);
		tfGender.setBounds(203, 128, 192, 28);
		contentPane.add(tfGender);

		JLabel label_4 = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638");
		label_4.setBounds(126, 170, 75, 28);
		contentPane.add(label_4);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(203, 170, 192, 28);
		contentPane.add(tfPhone);

		JLabel label_6 = new JLabel("\uB300\uC5EC\uC911\uC778 \uB3C4\uC11C");
		label_6.setBounds(14, 224, 121, 28);
		contentPane.add(label_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 261, 381, 141);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		btOk = new JButton("\uB2EB\uAE30");
		btOk.setFont(new Font("굴림", Font.PLAIN, 12));
		btOk.setBounds(302, 425, 93, 27);
		contentPane.add(btOk);

		btImg = new JButton("\uC774\uBBF8\uC9C0");
		btImg.setBounds(12, 146, 102, 23);

		contentPane.add(btImg);

		lbImg = new JLabel("");
		lbImg.setOpaque(true);
		lbImg.setBackground(Color.WHITE);
		lbImg.setBounds(12, 17, 102, 119);
		contentPane.add(lbImg);

		panelCard = new JPanel();
		panelCard.setBounds(185, 423, 105, 29);
		contentPane.add(panelCard);
		cardlayout = new CardLayout(0, 0);
		panelCard.setLayout(cardlayout);

		btModify = new JButton("\uBCC0\uACBD\uD558\uAE30");
		btModify.setFont(new Font("굴림", Font.PLAIN, 12));
		btConfirm = new JButton("\uBCC0\uACBD\uC644\uB8CC");
		btConfirm.setFont(new Font("굴림", Font.PLAIN, 12));
		panelCard.add(btModify, BT_MODIFY);
		panelCard.add(btConfirm, BT_CONFIRM);

		rentDefaultTable();
	}

	public void rentDefaultTable() {
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("도서명");
		columnNames.add("ISBN");
		columnNames.add("저자");
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		TableModel dataModel = new DefaultTableModel(data, columnNames);
		table.setModel(dataModel);
	}

	public void setMemberDto(MemberDto dto) {
		this.memberDto = dto;
	}

	public void setTF(MemberDto dto) {
		tfMember_id.setText(dto.getMember_id());
		tfName.setText(dto.getMember_name());
		tfDate.setText(dto.getBirthdayStr());
		tfGender.setText(dto.getGender());
		tfPhone.setText(dto.getPhone_number());

	}

	public void setTable(MemberDto dto) {
		columnNames = new Vector<String>();
		columnNames.add("ISBN");
		columnNames.add("도서명");
		columnNames.add("저자");
//		String memberId = dto.getMember_id();
		String memberId = tfMember_id.getText();
		BookDao bookDao = BookDao.getInstance();

		Vector<BookDto> vecLists = bookDao.selectOfMem(memberId);
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		int len = vecLists.size();

		for (int i = 0; i < len; i++) {
			Vector<String> contents = new Vector<String>();
			BookDto bookDto = vecLists.get(i);
			contents.add(bookDto.getIsbn());
			contents.add(bookDto.getName());
			contents.add(bookDto.getWriter());
			data.add(contents);
		}

		TableModel dataModel = new DefaultTableModel(data, columnNames);
		table.setModel(dataModel);
	}

	public void setEditable(boolean b) {
		tfDate.setEditable(b);
		tfGender.setEditable(b);
		tfMember_id.setEditable(false);
		tfName.setEditable(b);
		tfPhone.setEditable(b);
		btImg.setEnabled(b);
	}
}
