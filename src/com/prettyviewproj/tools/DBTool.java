package com.prettyviewproj.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTool {
	private static Connection conn  = null;
	public static Connection getConnection(){
		try {
			if(conn == null || conn.isClosed()){
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pretty_view_proj?useSSL=false&characterEncoding=utf8","root","123456");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;			
	}
	public static void closeConnection(){
		try {
			if(conn != null && !conn.isClosed()){
				conn.close();
				conn = null;
				}
		    }catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
