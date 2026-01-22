package com.qsp.util2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class ConnectionPool {
	private static List<Connection> pool = new ArrayList<Connection>();
	private static final String url = "jdbc:mysql://localhost:3306/employee";
	private static final String password = "021105";
	private static final String username = "root";
	private static final int poolsize = 10;

	static {
		for (int i = 1; i <= poolsize; i++) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection temp = DriverManager.getConnection(url, username, password);
				pool.add(temp);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}

	public static void destroy() throws SQLException {
		for (Connection con : pool) {
			con.close();
		}
		pool.clear();
	}

	public static Connection supply() {
		return pool.remove(0);
	}

	public static void accept(Connection connection) {
		pool.add(connection);
	}

	
	
	
	

}
