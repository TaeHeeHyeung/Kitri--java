package com.kitri.library.db;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.swing.JTextField;

//조회 추가 삭제... 조작
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
			System.out.println("클래스 로드 실패");
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
				System.out.println("member dao insert 데이터베이스 입력 성공");
				list.add(dto);
			} catch (SQLException e) {
				System.out.println("member dao insert 데이터베이스 입력 실패");
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
					//// 회원번호, 성별, 이름, 핸드폰번호, 주소, 이미지,생일 (date)
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
					System.out.println("삭제 완료");
					setAllList();
				} else {
					System.out.println("삭제 실패");
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
			System.out.println("연결 해제 실패");
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
				// 생년월일은 2019-04-09 의 값이 입력되어야한다.
				query = "select * from member where " + method + " between TO_DATE('" + search
						+ "','YYYY-MM-DD') and TO_DATE('" + search + "','YYYY-MM-DD')+1";
			}
			try {//
				list = new Vector<MemberDto>();
				Statement stmt = conn.createStatement();
				ResultSet rest = stmt.executeQuery(query);
				while (rest.next()) {
					//// 회원번호, 성별, 이름, 핸드폰번호, 주소, 이미지,생일 (date)
					MemberDto memberDto = new MemberDto(rest.getString(1), rest.getString(2), rest.getString(3),
							rest.getString(4), rest.getString(5), rest.getString(6), rest.getDate(7));
					list.add(memberDto);
				} // end while
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/*
			 * 주석지우기 ctrl+shift+\ 작동안됨... String preQuery
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
					//// 회원번호, 성별, 이름, 핸드폰번호, 주소, 이미지,생일 (date)
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
				System.out.println("MemberDao upDate 데이터베이스 변경 성공");
				close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("MemberDao upDateBook 데이터베이스 입력 실패");
				e.printStackTrace();
				close();
				return false;
			}
		}
		close();
		return false;
	}

}// end BookDao class
