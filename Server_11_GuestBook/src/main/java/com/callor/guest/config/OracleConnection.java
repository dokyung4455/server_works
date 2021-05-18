package com.callor.guest.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {

	private static Connection dbConn;

	static {

		String jdbcDriver = "oracle.jdbc.oracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "username";
		String password = "password";

		try {
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url,username,password);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Ojdbc6 Error 확인");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
