package com.qsp.repository2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.qsp.util2.ConnectionPool;

public class UserRepository {

	private static UserRepository object = new UserRepository();

	private UserRepository() {
	}

	public static UserRepository getInstance() {
		return object;
	}

	public String adduser(String username, String password, String role) {
		Connection con = ConnectionPool.supply();
		try {

			String sql = "insert into users values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, role);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return "Unexpected situation occured";
		}

		ConnectionPool.accept(con);
		return "User saved";
	}

	public ResultSet getUserByUserName(String username) {
		Connection con = ConnectionPool.supply();
		ResultSet rs = null;

		try {
			String sql = "select * from users where username=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectionPool.accept(con);
		return rs;
	}

}
