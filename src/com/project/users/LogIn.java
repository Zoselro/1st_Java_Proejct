package com.project.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.jdbcutil.CommonJDBCUtil;

public class LogIn {
	
	CommonJDBCUtil cj = new CommonJDBCUtil();
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	public List<UsersVO> login(String id, String pw) {
		List<UsersVO> list = null;
		
		try {

			conn = cj.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, PASSWORD, NAME, RRN, EMAIL, PHONE, ADDRESS ");
			sql.append("  FROM USERS ");
			sql.append("WHERE ID = ? ");
			sql.append("  AND PASSWORD = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
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
			e.printStackTrace();
		} finally {
			cj.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public List<UsersVO> login(String id) {
		List<UsersVO> list = null;
		
		try {

			conn = cj.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, PASSWORD, NAME, RRN, EMAIL, PHONE, ADDRESS ");
			sql.append("  FROM USERS ");
			sql.append("WHERE ID = ? ");
			sql.append("  AND PASSWORD = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, id);
			
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
			e.printStackTrace();
		} finally {
			cj.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	
	
}
