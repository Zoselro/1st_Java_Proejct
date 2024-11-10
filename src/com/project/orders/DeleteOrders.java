package com.project.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.project.jdbcutil.CommonJDBCUtil;
import com.project.orders.OrdersBookVO;
import com.project.users.UsersVO;
public class DeleteOrders {
	UsersVO vo = new UsersVO();
	OrdersBookVO ovo = new OrdersBookVO();
	
	
    public int delete(String id, String name, String rrn) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;

        try {
            // 데이터베이스 연결
            conn = CommonJDBCUtil.getConnection();
            conn.setAutoCommit(false); // 수동 커밋 모드 설정

            // 첫 번째 테이블에서 데이터 삭제
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM USERS WHERE ID = ? ");
            sql.append("                  AND NAME = ? ");
            sql.append("                  AND RRN = ? ");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, rrn);
            result = pstmt.executeUpdate();

            // 두 번째 테이블에서 데이터 삭제
            StringBuilder sql2 = new StringBuilder();// 변경 필요
            sql2.append("DELETE FROM ORDERSBOOK WHERE ID = ? ");
            pstmt2 = conn.prepareStatement(sql2.toString());
            pstmt2.setString(1, id);
            result += pstmt2.executeUpdate();

            // 트랜잭션 커밋
            conn.commit();
        } catch (SQLException e) {
            // 롤백 실행
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (pstmt2 != null) {
                    pstmt2.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DeleteOrders deleter = new DeleteOrders();
        String id = sc.nextLine();
        String name = sc.nextLine();
        String rrn = sc.nextLine();
        
        
        int deletionResult = deleter.delete(id, name, rrn);

        if (deletionResult > 0) {
            System.out.println("데이터 삭제 완료");
        } else {
            System.out.println("데이터 삭제 실패");
	        }
	    }
	}


