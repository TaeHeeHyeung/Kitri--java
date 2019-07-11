package com.kitri.library.db;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.swing.JTextField;

//��ȸ �߰� ����... ����
public class MemberDao extends DBConnector {
	private PreparedStatement pstmt;
	private ResultSet stmt;
	static private MemberDao memberDao = new MemberDao();

	Vector<MemberDto> list = new Vector<MemberDto>();

	public static MemberDao getInstance() {
		return memberDao;
	}

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� �ε� ����");
			e.printStackTrace();
		}

	}// end static classload

	private MemberDao() {
		setAllList();
	}

	// {"book_id","book_name","writer","publisher","date","positon","image_path"};

	public void insert(MemberDto dto) {
		if (connect()) {
			String query = "insert into member values (?,?,?,?,?,?,?)";
			try {

				if (dto.birthday == null) {
					Date date = new Date(new java.util.Date().getTime());
					dto.birthday = date;
				}
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, dto.member_id);
				pstmt.setString(2, dto.gender);
				pstmt.setString(3, dto.member_name);
				pstmt.setString(4, dto.phone_number);
				pstmt.setString(5, dto.address);
				pstmt.setString(6, dto.image_path);
				pstmt.setDate(7, dto.birthday);
				pstmt.executeUpdate();
				System.out.println("member dao insert �����ͺ��̽� �Է� ����");
				list.add(dto);
			} catch (SQLException e) {
				System.out.println("member dao insert �����ͺ��̽� �Է� ����");
				e.printStackTrace();
			}
		}
	}// end insert

	public void setAllList() {
		if (connect()) {
			String query = "select * from member order by member_id";
			try {
				list = new Vector<MemberDto>();
				pstmt = conn.prepareStatement(query);
				stmt = pstmt.executeQuery(query);
				while (stmt.next()) {
					//// ȸ����ȣ, ����, �̸�, �ڵ�����ȣ, �ּ�, �̹���,���� (date)
					MemberDto memberDto = new MemberDto(stmt.getString(1), stmt.getString(2), stmt.getString(3),
							stmt.getString(4), stmt.getString(5), stmt.getString(6), stmt.getDate(7));
					list.add(memberDto);
				} // end while

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();

	}// end selectListAll

	public void delete(String member_id) {
		String query = "delete from member where member_id = ?";
		try {
			if (connect()) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, member_id);
				int n = pstmt.executeUpdate();
				if (n > 0) {
					System.out.println("���� �Ϸ�");
					setAllList();
				} else {
					System.out.println("���� ����");
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
	}// end delete

	private void close() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("���� ���� ����");
			e.printStackTrace();
		}
	}

	public Vector<MemberDto> getList() {
		return list;
	}

	public Vector<MemberDto> select(String method, String search) {
		if (connect()) {
			String query = null;
			if (!method.equals("birthday")) {
				query = "select * from member where " + method + " like '%" + search + "%'";
			} else {
				// ��������� 2019-04-09 �� ���� �ԷµǾ���Ѵ�.
				query = "select * from member where " + method + " between TO_DATE('" + search
						+ "','YYYY-MM-DD') and TO_DATE('" + search + "','YYYY-MM-DD')+1";
			}
			try {//
				list = new Vector<MemberDto>();
				Statement stmt = conn.createStatement();
				ResultSet rest = stmt.executeQuery(query);
				while (rest.next()) {
					//// ȸ����ȣ, ����, �̸�, �ڵ�����ȣ, �ּ�, �̹���,���� (date)
					MemberDto memberDto = new MemberDto(rest.getString(1), rest.getString(2), rest.getString(3),
							rest.getString(4), rest.getString(5), rest.getString(6), rest.getDate(7));
					list.add(memberDto);
				} // end while
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/*
			 * �ּ������ ctrl+shift+\ �۵��ȵ�... String preQuery
			 * ="select * from member where ? like '%' || ? || '%'"; try { pstmt =
			 * conn.prepareStatement(preQuery); pstmt.setString(1, method);
			 * pstmt.setString(2, search); stmt = pstmt.executeQuery();
			 * 
			 * while (stmt.next()) { System.out.println("pstmt"+ stmt.getString(1)); } }
			 * catch (SQLException e) { e.printStackTrace(); }
			 */

		}
		close();
		return null;
	}

	public MemberDto select(String member_id) {
		if (connect()) {
			String query = "select * from member where member_id like '" + member_id + "'";
			try {
				MemberDto memberDto = null;

				Statement stmt = conn.createStatement();
				ResultSet rest = stmt.executeQuery(query);
				while (rest.next()) {
					//// ȸ����ȣ, ����, �̸�, �ڵ�����ȣ, �ּ�, �̹���,���� (date)
					memberDto = new MemberDto(rest.getString(1), rest.getString(2), rest.getString(3),
							rest.getString(4), rest.getString(5), rest.getString(6), rest.getDate(7));

				} // end while
				return memberDto;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();
		return null;
	}

	public boolean update(String memberId, MemberDto dto) {
		if (connect()) {
			String query = "update member set " + "member_id = ?," + "gender = ?," + "name = ?," + "phone_number = ?,"
					+ "address = ?," + "image = ?," + "birthday = ? " + "where member_id like '" + memberId + "'";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, dto.member_id);
				pstmt.setString(2, dto.gender);
				pstmt.setString(3, dto.member_name);
				pstmt.setString(4, dto.phone_number);
				pstmt.setString(5, dto.address);
				pstmt.setString(6, dto.image_path);
				pstmt.setDate(7, dto.birthday);
				pstmt.executeUpdate();
				System.out.println("MemberDao upDate �����ͺ��̽� ���� ����");
				close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("MemberDao upDateBook �����ͺ��̽� �Է� ����");
				e.printStackTrace();
				close();
				return false;
			}
		}
		close();
		return false;
	}

}// end BookDao class
