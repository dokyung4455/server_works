package com.callor.book.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// 싱글톤(Single Tone) 패턴
// 프로젝트를 수행함에 있어 필요한 자원(Resource)를 만드는 방법으로
// 같은 자원을 계속 만들지 않고 한번만 만들어두고 여러곳에서 활용하는 방법
public class DBContract {
	
	
	
	private static Connection dbConn;
	
	// static 자동 생성자
	// 프로젝트가 Run 되면 무조건 코드를 실행되는 method
	static {
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "도서대여프로젝트";
		String password = "도서대여프로젝트";
		
		try {
			Class.forName(jdbcDriver);
			dbConn = DriverManager.getConnection(url,userName,password);
			System.out.println("DB Connection OK!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Oracle DB Driver 없음");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Oracle DB Connect Error..");
		}
		
	} // end static
	
	public static Connection getDBConnection() {
		return dbConn;
	}

}
