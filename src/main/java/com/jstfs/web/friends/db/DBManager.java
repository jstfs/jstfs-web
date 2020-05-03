package com.jstfs.web.friends.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	public static final String DB_NAME = "friends";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER_NAME = "jstfs-web";
	public static final String PWD = "zuohaoziji";
	public static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	//?userSSL=true &useUnicode=true &characterEncoding=UTF8 &serverTimezone=GMT
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	/**
	 * 用来执行增删改的方法
	 */
	public int executeUpdate(String sql) {
		int row = 0;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			row = stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	/**
	 * 用来执行查询的方法
	 */
	public ResultSet executeQuery(String sql) {
		try {			
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 关闭连接
	 */
	public void closeConn() {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, USER_NAME, PWD);
		return conn;
	}
}