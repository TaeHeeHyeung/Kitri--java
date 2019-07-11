package com.kitri.library.member.mng;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.kitri.library.controller.Controller;
import com.kitri.library.db.*;
import com.kitri.library.file.ImageFile;
import com.kitri.library.member.add.MemberAdd;
import com.kitri.library.member.info.Memberinfo;

import java.awt.SystemColor;
import java.awt.event.*;
import java.util.Vector;
import java.awt.Font;

public class MemberMng extends JFrame {
	Memberinfo memberinfo;
	MemberAdd memberAdd;
	public ImageFile imageFile;

	public MemberDao memberDao;
	MemberController memberController;

	public JPanel contentPane;
	public JTextField tfSearch;
	public JTable table;
	JScrollPane scrollPane;

	DefaultTableModel model;

	JComboBox comboBox;
	JButton btSearch;
	JButton btAdd;
	JButton btDelete;
	JButton btCancel;

	String person[] = { "회원번호", "이름", "생년월일" };// 콤보박스 리스트
	String header[] = new String[] { "회원번호", "이름", "생년월일", "주소", "성별", "핸드폰번호"};
	JButton btUpdate;

	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// MemberMng frame = new MemberMng();
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
	public MemberMng() {
		memberDao = MemberDao.getInstance();
		imageFile = new ImageFile();
		memberAdd = new MemberAdd(this);
		memberinfo = new Memberinfo(this);
		memberController = new MemberController(this);
		uiInit();
		// tfSearch.setText("내용을 입력해주세요.");
		// 컨트롤러 연결
		setLocationRelativeTo(null); // 프레임을 화면 정가운데 위치 키워드 :중앙, 가운데

		// addActionListener
		btSearch.addActionListener(memberController);
		btAdd.addActionListener(memberController);
		btDelete.addActionListener(memberController);
		btCancel.addActionListener(memberController);
		btUpdate.addActionListener(memberController);
		// 종료버튼 Window리스너
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // 종료 막기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				memberController.memberService.close();
			}
		});
	}

	private void uiInit() {
		setTitle("\uD68C\uC6D0\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 430);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox = new JComboBox(person);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uD68C\uC6D0\uBC88\uD638", "\uC774\uB984"}));
		comboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		comboBox.setForeground(SystemColor.inactiveCaptionText);

		comboBox.setToolTipText("\uD68C\uC6D0\uC544\uC774\uB514");
		comboBox.setBounds(14, 12, 105, 24);
		contentPane.add(comboBox);

		tfSearch = new JTextField();
		tfSearch.setBounds(154, 12, 385, 24);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);

		btSearch = new JButton("\uAC80\uC0C9");
		btSearch.setForeground(SystemColor.inactiveCaptionText);
		btSearch.setFont(new Font("굴림", Font.PLAIN, 12));
		btSearch.setBackground(Color.LIGHT_GRAY);
		btSearch.setBounds(552, 12, 105, 28);
		contentPane.add(btSearch);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 48, 640, 290);
		contentPane.add(scrollPane);

		btAdd = new JButton("\uCD94\uAC00");
		btAdd.setForeground(SystemColor.inactiveCaptionText);
		btAdd.setFont(new Font("굴림", Font.PLAIN, 12));
		btAdd.setBounds(14, 352, 97, 23);
		contentPane.add(btAdd);

		btDelete = new JButton("\uC0AD\uC81C");
		btDelete.setForeground(SystemColor.inactiveCaptionText);
		btDelete.setFont(new Font("굴림", Font.PLAIN, 12));
		btDelete.setBounds(133, 352, 97, 23);
		contentPane.add(btDelete);

		btCancel = new JButton("\uCDE8\uC18C");
		btCancel.setForeground(SystemColor.inactiveCaptionText);
		btCancel.setFont(new Font("굴림", Font.PLAIN, 12));
		btCancel.setBounds(552, 352, 97, 23);
		contentPane.add(btCancel);

		int size = memberDao.getList().size();

		String contents[][] = new String[size][header.length];
		for (int i = 0; i < size; i++) {
			MemberDto memDto = memberDao.getList().get(i);
			String[] content = new String[] { memDto.getMember_id(), memDto.getMember_name(),
					memDto.getBirthday().toString(), memDto.getAddress(), memDto.getGender(),
					memDto.getPhone_number()};
			contents[i] = content;
		}

		table = new JTable(contents, header);// model로 jtable생성
		scrollPane.setViewportView(table);

		btUpdate = new JButton("\uC218\uC815");
		btUpdate.setBounds(242, 352, 97, 23);
		contentPane.add(btUpdate);
	}

	// 테이블 값 갱신
	public void tableModelUpdate() {
		memberDao.setAllList();
		Vector<MemberDto> list = memberDao.getList();
		int len = list.size();
		String[][] contents = new String[len][header.length];
		for (int i = 0; i < len; i++) {
			MemberDto memDto = memberDao.getList().get(i);
			String[] content = new String[] { memDto.getMember_id(), memDto.getMember_name(),
					memDto.getBirthday().toString(), memDto.getAddress(), memDto.getGender(),
					memDto.getPhone_number()};
			contents[i] = content;
		}

		// 테이블 갱신
		DefaultTableModel model = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
	}// end tableModelUpdate


}
