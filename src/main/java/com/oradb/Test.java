package com.oradb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws SQLException {
		//Connection conn = DbUtil.getCon();
		ResultSet rs = DBUtil.find("select 1 from dual");
		while(rs.next()) {
			System.out.println(rs.getInt(0));
		}
	}
}
