package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 싱글톤 패턴
 * 자원(Resource: 하드웨어 장치, 네트워크, 파일 .. ) 을 코드에서 활용할때는 최소한의 연결을 하여 사용하는 것이 여러모로 좋다.
 * 
 * 필요한 연결객체를 프로젝트에서 1개만 선언하고 공용으로 사용하는 방법
 */
public class DBContract {
	
	private static Connection dbConn;
	
	// static 초기화 블럭
	// static으로 선언된 변수나 객체를 프로젝트가 시작될때 자동으로 생성하는 코드를 작성하는 부분
	// 
	// Connection 객체인 dbConn
	static {
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "gbUser";
		String pass = "12345";
		
		try {
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				dbConn 
				= DriverManager.getConnection(url,user,pass);
			}
			System.out.println("MySQL 연결 OK!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Get Instance method
	// Instance : 사용준비(생성된, 초기화된) 객체 private static으로 선언된 변수, 객체를
	// 다른곳에서 사용할 수 있도록 제공하는 method
	public static Connection getDbConn() {
		return dbConn;
	}
}
