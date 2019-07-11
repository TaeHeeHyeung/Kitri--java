package com.kitri.library.db;

import java.sql.*;
import java.util.Vector;

public class RentDao extends DBConnector {

	private PreparedStatement pstmt;
	private ResultSet stmt;
	static private RentDao rentDao = new RentDao();
//	int rent_id;
//	String isbn;
//	String member_id;
//	int extension_count;
//	Date rent_date;
//	Date extension_date;

	Vector<RentDto> list = new Vector<RentDto>();

	public static RentDao getInstance() {
		return rentDao;
	}

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패");
			e.printStackTrace();
		}

	}// end static classload

	private RentDao() {
		setAllList();
	}

//	int rent_id;
//	String isbn;
//	String member_id;
//	int extension_count;
//	Date rent_date;
//	Date extension_date;
	public void insert(RentDto dto) {
		if (connect()) {
			String query = "insert into rent values (SEQ_RENT.NEXTVAL,?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, dto.isbn);
				pstmt.setString(2, dto.member_id);
				pstmt.setInt(3, dto.extension_count);
				pstmt.setDate(4, dto.rent_date);
				pstmt.setDate(5, dto.extension_date);
				pstmt.setString(6, dto.renting);
				pstmt.executeUpdate();
				System.out.println("rent dao insert 데이터베이스 입력 성공");
				list.add(dto);
			} catch (SQLException e) {
				System.out.println("rent dao insert 데이터베이스 입력 실패");
				e.printStackTrace();
			}
		}
	}// end insert

	private void setAllList() {
		if (connect()) {
			String query = "select * from rent";
			try {
				list = new Vector<RentDto>();
				pstmt = conn.prepareStatement(query);
				stmt = pstmt.executeQuery(query);
				while (stmt.next()) {
					//// 회원번호, 성별, 이름, 핸드폰번호, 주소, 이미지,생일 (date)
					RentDto dto = new RentDto(stmt.getInt(1), stmt.getString(2), stmt.getString(3), stmt.getInt(4),
							stmt.getDate(5), stmt.getDate(6), stmt.getString(7));
					list.add(dto);

				} // end while

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();

	}// end selectListAll

	// member
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

	public Vector<RentDto> getList() {
		return list;
	}

	public RentDto select(String isbn) {
		String query = "select * from rent where ISBN = ?";

		try {
			if (connect()) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, isbn);
				int n = pstmt.executeUpdate();
				if (n > 0) {
					System.out.println("검색완료");
					RentDto dto = new RentDto(stmt.getInt(1), stmt.getString(2), stmt.getString(3), stmt.getInt(4),
							stmt.getDate(5), stmt.getDate(6), stmt.getString(7));
					return dto;
				} else {
					System.out.println("검색실패");
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return null;
	}

}
