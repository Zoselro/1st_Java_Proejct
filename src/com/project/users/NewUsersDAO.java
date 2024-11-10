package com.project.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.users.UsersVO;
import com.project.jdbcutil.CommonJDBCUtil;




public class NewUsersDAO {
	private static final Connection conn = null;
	private static final PreparedStatement pstmt = null;	
	CommonJDBCUtil cj = new CommonJDBCUtil();

	public List<UsersVO> UserSelectID(String name, String rrn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UsersVO> users  = null;
		try {
			
			
			conn = cj.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, PASSWORD, NAME,"
					+ " RRN, EMAIL, PHONE, ADDRESS ");
			sql.append("  FROM USERS ");
			sql.append("WHERE NAME = ? "
						+"AND RRN = ?");
			sql.append(" ORDER BY USERNUMBER ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			pstmt.setString(2, rrn);
			
			rs = pstmt.executeQuery();
		
			users = new ArrayList<>();
			
			while(rs.next()) {
				UsersVO vo = new UsersVO();
				vo.setId(rs.getString("ID"));
				vo.setPw(rs.getString("PASSWORD"));
				vo.setName(rs.getString("NAME"));
				vo.setRrn(rs.getString("RRN"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setAdd(rs.getString("ADDRESS"));
				
				users.add(vo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cj.close(conn, pstmt, rs);
		}

		return users;
		

	}
	///////////////
	public List<UsersVO> UserSelectID() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UsersVO> users  = null;
		try {
			
			
			conn = cj.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, PASSWORD, NAME,"
					+ " RRN, EMAIL, PHONE, ADDRESS ");
			sql.append("  FROM USERS ");
			sql.append(" ORDER BY USERNUMBER ");
			
			pstmt = conn.prepareStatement(sql.toString());

			
			rs = pstmt.executeQuery();
		
			users = new ArrayList<>();
			
			while(rs.next()) {
				UsersVO vo = new UsersVO();
				vo.setId(rs.getString("ID"));
				vo.setPw(rs.getString("PASSWORD"));
				vo.setName(rs.getString("NAME"));
				vo.setRrn(rs.getString("RRN"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setAdd(rs.getString("ADDRESS"));
				
				users.add(vo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cj.close(conn, pstmt, rs);
		}

		return users;
		

	}
	
	////////////////////
	public List<UsersVO> LogIn(String id, String pw) {
		List<UsersVO> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = cj.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID, PASSWORD, NAME, RRN, EMAIL, PHONE, ADDRESS ");
			sb.append("  FROM USERS ");
			sb.append("WHERE ID = ? ");
			sb.append("  AND PASSWORD = ? ");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<UsersVO>();
			
			while (rs.next()) {
				UsersVO vo = new UsersVO();
				vo.setId(rs.getString("ID"));
				vo.setPw(rs.getString("PASSWORD"));
				vo.setName(rs.getString("NAME"));
				vo.setRrn(rs.getString("RRN"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setAdd(rs.getString("ADDRESS"));
				list.add(vo);		
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cj.close(conn, pstmt, rs);
		}
		
		
		return list;
	
	
	}
	

	public int insert(UsersVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;	
		
		try {
			conn = cj.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO USERS ");
			sql.append("       (USERNUMBER, ID, PASSWORD, NAME, RRN, EMAIL, PHONE, ADDRESS) ");
			sql.append("VALUES ((SELECT NVL(MAX(USERNUMBER),0) + 1 FROM USERS), ?, ?, ?, ?, ?, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRrn());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getAddress());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
		//	e.printStackTrace();
		} finally {
			cj.close(conn, pstmt);
		}

		return result;
	}
	
	public int update(UsersVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = cj.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE USERS ");
			sb.append("   SET PASSWORD = ? ");
			sb.append(" WHERE ID = ? ");
			sb.append("   AND NAME = ? ");
			sb.append("   AND RRN = ? ");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRrn());
			
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cj.close(conn, pstmt);
		}
		
		
		
		return result;
	}
	
	public List<UsersVO> selectone() {
		List<UsersVO> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = cj.getConnection();

			StringBuilder sb = new StringBuilder();
			sb.append("SELECT NAME, RRN ");
			sb.append("  FROM USERS ");
			sb.append(" ORDER BY NAME ");

			pstmt = conn.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			list = new ArrayList<UsersVO>();

			while (rs.next()) {
				UsersVO vo = new UsersVO(
						rs.getString("ID"),
						rs.getString("PASSWORD"), 
						rs.getString("NAME"),
						rs.getString("RRN"), 
						rs.getString("EMAIL"), 
						rs.getString("PHONE"), 
						rs.getString("ADDRESS"));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cj.close(conn, pstmt, rs);
		}

		return list;
	}

	public int delete(String name, String rrn) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = cj.getConnection();

			String sql = "DELETE FROM USERS WHERE NAME = ? AND RRN = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, rrn);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[예외발생] " + e.getMessage());
			e.printStackTrace();
		} finally {
			cj.close(conn, pstmt);
		}

		return count;
	}

	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	






