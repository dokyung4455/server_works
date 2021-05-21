package com.callor.maven.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDBConnection {

	Connection DBConn;

	public MysqlDBConnection() {
		String jdbcdriver = "com.mysql.cj.jdbc.Driver";
		String url = "";
		String username = "";
		String password = "";

		try {
			Class.forName(jdbcdriver);
			DBConn = DriverManager.getConnection(url, username, password);
			System.out.println("접속완료");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
