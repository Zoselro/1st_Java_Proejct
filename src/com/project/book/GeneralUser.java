package com.project.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.jdbcutil.CommonJDBCUtil;
import com.project.users.UsersVO;


public class GeneralUser {
	
	CommonJDBCUtil cj = new CommonJDBCUtil();
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	public List<BookVO> selectBookname() {
		
		List<BookVO> list = null;
		try {	
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = CommonJDBCUtil.getConnection();
			
			//3. Statement 문 실행(SQL 문 실행)
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT BOOKID, BOOKNAME, GENRE, WRITER, PRICE , BOOKTYPE"
					+ ", BOOKDATE FROM BOOK ");
			sql.append("ORDER BY BOOKID");
			
			
			pstmt = conn.prepareStatement(sql.toString());
			
			
			rs = pstmt.executeQuery();
	
			
			//4. SQL 실행 결과에 대한 처리
			list = new ArrayList<BookVO>();
			
			while(rs.next()) {
				BookVO vo = new BookVO(
						rs.getInt("BOOKID"),
						rs.getString("BOOKNAME"),
						rs.getString("GENRE"),
						rs.getString("WRITER"),
						rs.getString("PRICE"),
						rs.getString("BOOKDATE"),
						rs.getString("BOOKTYPE")
						);
				list.add(vo);
				System.out.println(vo);
			}
			if (list.isEmpty()) {
	            System.out.println("찾으시는 책이 없습니다.");
	        }
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		//5. 클로징 처리에 의한 자원 반납
		cj.close(conn, pstmt, rs);
		
		return list;
	}
	
	
public List<BookVO> selectGenre(int num) {
		
		List<BookVO> list = null;
		String genre = "";
		try {	
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = CommonJDBCUtil.getConnection();
			
			//3. Statement 문 실행(SQL 문 실행)
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT BOOKID, BOOKNAME, GENRE, WRITER, PRICE , BOOKTYPE"
					+ ", BOOKDATE FROM BOOK ");
			sql.append("WHERE GENRE = ? ");
			sql.append("ORDER BY BOOKID");
			
			
			pstmt = conn.prepareStatement(sql.toString());
			
			if(num == 1) genre = "판타지";
			if(num == 2) genre = "로맨스";
			if(num == 3) genre = "무협";
			if(num == 4) genre = "개그";
			if(num == 5) genre = "드라마";
			
			pstmt.setString(1, genre);
			
			rs = pstmt.executeQuery();
	
			
			//4. SQL 실행 결과에 대한 처리
			list = new ArrayList<BookVO>();
			
			while(rs.next()) {
				BookVO vo = new BookVO(
						rs.getInt("BOOKID"),
						rs.getString("BOOKNAME"),
						rs.getString("GENRE"),
						rs.getString("WRITER"),
						rs.getString("PRICE"),
						rs.getString("BOOKDATE"),
						rs.getString("BOOKTYPE")
						);
				list.add(vo);
				System.out.println(vo);
			}
			if (list.isEmpty()) {
	            System.out.println("찾으시는 장르가 없습니다.");
	        }
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		//5. 클로징 처리에 의한 자원 반납
		cj.close(conn, pstmt, rs);
		
		return list;
	}
	public List<BookVO> selectGenre(String bname,String type) {
	
		List<BookVO> list = null;
		String genre = "";
		try {	
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = CommonJDBCUtil.getConnection();
			
			//3. Statement 문 실행(SQL 문 실행)
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT BOOKID, BOOKNAME, GENRE, WRITER, PRICE , BOOKTYPE"
					+ ", BOOKDATE FROM BOOK ");
			sql.append("WHERE BOOKNAME = ? ");
			sql.append("AND BOOKTYPE = ? ");
			
			
			pstmt = conn.prepareStatement(sql.toString());
			
			
			pstmt.setString(1, bname);
			pstmt.setString(2, type);
			
			rs = pstmt.executeQuery();
	
			
			//4. SQL 실행 결과에 대한 처리
			list = new ArrayList<BookVO>();
			
			while(rs.next()) {
				BookVO vo = new BookVO(
						rs.getInt("BOOKID"),
						rs.getString("BOOKNAME"),
						rs.getString("GENRE"),
						rs.getString("WRITER"),
						rs.getString("PRICE"),
						rs.getString("BOOKDATE"),
						rs.getString("BOOKTYPE")
						);
				list.add(vo);
				System.out.println(vo);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		//5. 클로징 처리에 의한 자원 반납
		cj.close(conn, pstmt, rs);
		
		return list;
	}
	
	public int selectBook(String name, String genre, String writer, String price, String type) {
	    int result = 0;
	    try {
	        //2. DB연결 - Connection 객체 생성 <- JDBCUtil.getConnection()
	        conn = CommonJDBCUtil.getConnection();

	        //3. PreparedStatement 문 실행(SQL 문 실행)

	        StringBuilder sql = new StringBuilder();
	        sql.append("SELECT BOOKID, BOOKNAME, GENRE, WRITER, PRICE, BOOKTYPE ");
	        sql.append("FROM BOOK ");
	        sql.append("WHERE BOOKNAME = ? AND BOOKTYPE = ? ");
	        sql.append("ORDER BY BOOKNAME");

	        pstmt = conn.prepareStatement(sql.toString());
	        pstmt.setString(1, name);
	        pstmt.setString(2, type);
	        rs = pstmt.executeQuery();

	        if (!rs.next()) {
	            StringBuilder sql2 = new StringBuilder();
	            sql2.append("INSERT INTO BOOK ");
	            sql2.append("(BOOKID, BOOKNAME, GENRE, WRITER, PRICE, BOOKDATE, BOOKTYPE) ");
	            sql2.append("VALUES ((SELECT NVL(MAX(BOOKID), 0) + 1 FROM BOOK), ?, ?, ?, ?, TO_CHAR(SYSDATE), ?)");

	            pstmt = conn.prepareStatement(sql2.toString());
	            pstmt.setString(1, name);
	            pstmt.setString(2, genre);
	            pstmt.setString(3, writer);
	            pstmt.setString(4, price);
	            pstmt.setString(5, type);

	            result = pstmt.executeUpdate();
	            System.out.println("책이 추가 되었습니다");
	        } else {
	        	System.out.println("중복된 책이 존재합니다.");
	        }

	        //4. SQL 실행 결과에 대한 처리
	        // (여기에 추가적인 로직을 넣으셔서 필요한 처리를 수행하십시오)

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        //5. 클로징 처리에 의한 자원 반납
	        CommonJDBCUtil.close(conn, pstmt, rs);
	    }

	    return result;
	}

}
