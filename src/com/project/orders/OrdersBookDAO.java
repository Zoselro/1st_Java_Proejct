package com.project.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.jdbcutil.CommonJDBCUtil;

public class OrdersBookDAO {
	CommonJDBCUtil ju = new CommonJDBCUtil();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<OrdersBookVO> select(String id) {
		List<OrdersBookVO> list = null;
		
		try {
			conn = ju.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ORDERID, ID, BOOKNAME, SALEDATE, BOOKTYPE ");
			sql.append("FROM ORDERSBOOK ");
			sql.append("WHERE ID = ? ");
			sql.append("ORDER BY ORDERID ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList();
			
			while(rs.next()) {
				OrdersBookVO vo = new OrdersBookVO(
						rs.getInt("ORDERID"),
						rs.getString("ID"),
						rs.getString("BOOKNAME"),
						rs.getString("SALEDATE"),
						rs.getString("BOOKTYPE")
						);
				list.add(vo);
				System.out.println(vo);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ju.close(conn, pstmt, rs);
		}
		
		
	
		return list;
	}
	
	public List<OrdersBookVO> select(String id, String bookname) {
		List<OrdersBookVO> list = null;
		
		try {
			conn = ju.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ORDERID, ID, BOOKNAME, SALEDATE, BOOKTYPE ");
			sql.append("FROM ORDERSBOOK ");
			sql.append("WHERE ID = ? AND BOOKNAME = ?");
			sql.append("ORDER BY ORDERID ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, id);
			pstmt.setString(2, bookname);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList();
			
			while(rs.next()) {
				OrdersBookVO vo = new OrdersBookVO(
						rs.getInt("ORDERID"),
						rs.getString("ID"),
						rs.getString("BOOKNAME"),
						rs.getString("SALEDATE"),
						rs.getString("BOOKTYPE")
						);
				list.add(vo);
				System.out.println(vo);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ju.close(conn, pstmt, rs);
		}
		
		
	
		return list;
	}
	
	
	


	public int salebook(OrdersBookVO vo) {
		int result = 0;
		
		try {
			conn = ju.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ORDERSBOOK ");
			sql.append("		(ORDERID, ID, BOOKNAME, SALEDATE, BOOKTYPE) ");
			sql.append("VALUES ((SELECT NVL(MAX(ORDERID), 0) + 1 FROM ORDERSBOOK), ?, ?, TO_CHAR(SYSDATE,'YYYY-MM-DD'), ?) ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getid());
			pstmt.setString(2, vo.getBookname());
			pstmt.setString(3, vo.getBooktype());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ju.close(conn, pstmt);
		}
		
		
		
		
		return result;
	}
}
