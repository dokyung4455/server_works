package com.callor.html;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String uri = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "myfood";
		String password = "myfood";
		
		if(dbConn == null) {
			try {
				Class.forName(jdbcDriver);		
				dbConn = DriverManager.getConnection(uri, username, password);
				System.out.println("오라클 접속완료");
			} catch (ClassNotFoundException e) {
				System.out.println("Ojdbc6.jar 오류");
			} catch (SQLException e) {
				System.out.println("=".repeat(50));
				System.out.println("접속정보 오류");
				System.out.println("uri,username,password를 확인하세요.");
				System.out.println("uri : " + uri);
				System.out.println("username : " + username);
				System.out.println("password : " + password);
			}
		}
	}
	
	public static Connection getDbConnection() {
		return dbConn;
	}

}
