package com.soft.maneger.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static String user = "scott";
	static String password = "tiger";

	public static Connection getConnect() throws SQLException {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);

			System.out.println("连接成功");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return con;

	}

	public static void main(String[] args) {
		Conn conn = new Conn();
		try {
			conn.getConnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
