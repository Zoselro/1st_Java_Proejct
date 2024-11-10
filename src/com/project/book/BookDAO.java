package com.project.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.jdbcutil.CommonJDBCUtil;

public class BookDAO {
	
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;	
	CommonJDBCUtil cj = new CommonJDBCUtil();
	
	public int bookinsert(BookVO vo) {
		int result = 0;
		
		
		try {
			conn = cj.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO BOOK " );
			sql.append("		(BOOKID, BOOKNAME, GENRE, WRITER, PRICE, BOOKDATE, BOOKTYPE) " );
			sql.append("VALUES ((SELECT NVL(MAX(BOOKID), 0) + 1 FROM BOOK), ?, ?, ?, ?, TO_CHAR(SYSDATE), ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, vo.getBookname());
			pstmt.setString(2, vo.getGenre());
			pstmt.setString(3, vo.getWriter());
			pstmt.setString(4, vo.getPrice());
			pstmt.setString(5, vo.getBooktype());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cj.close(conn, pstmt);
		}
		
		
		return result;
	}
	
	public int bookdelete(BookVO vo) {
		int result = 0;

		try {
			conn = cj.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM BOOK " );
			sql.append(" WHERE BOOKNAME = ? " );
			sql.append("AND BOOKTYPE = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getBookname());
			pstmt.setString(2, vo.getBooktype());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cj.close(conn, pstmt);
		}
		
		
		
		
		return result;
	}
}
