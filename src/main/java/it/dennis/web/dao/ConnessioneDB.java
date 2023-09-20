package it.dennis.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnessioneDB {
	private static String url="jdbc:mysql://localhost:3306/demo";
	private static String username = "root";
	private static String password = "root";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
