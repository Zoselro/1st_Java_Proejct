package com.project.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonJDBCUtil {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@192.168.18.25:1521:xe";
	private static final String USER = "admin";
	private static final String PSW = "admin";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL,USER,PSW);
		} catch (SQLException e) {
			System.out.println("[예외발생] 접속실패!! - " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
