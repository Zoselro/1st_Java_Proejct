package com.project.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.admin.AdminVO;
import com.project.jdbcutil.CommonJDBCUtil;

public class NewAdmin {

	CommonJDBCUtil cj = new CommonJDBCUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<AdminVO> list = null;

	public List<AdminVO> adminlogin(String codenumber, String password) {
		try {

			conn = cj.getConnection();

			StringBuilder sr = new StringBuilder();
			sr.append("SELECT CODENUMBER, PASSWORD, NAME ");
			sr.append("  FROM ADMIN ");
			sr.append("WHERE CODENUMBER = ? ");
			sr.append("  AND PASSWORD = ? ");

			pstmt = conn.prepareStatement(sr.toString());
			pstmt.setString(1, codenumber);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			list = new ArrayList<AdminVO>();

			while (rs.next()) {
				AdminVO vo = new AdminVO();
				vo.setCodenumber(rs.getString("CODENUMBER"));
				vo.setPassword(rs.getString("PASSWORD"));
				vo.setName(rs.getString("NAME"));
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
