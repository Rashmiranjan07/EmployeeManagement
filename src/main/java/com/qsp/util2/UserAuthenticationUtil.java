package com.qsp.util2;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qsp.repository2.UserRepository;

public class UserAuthenticationUtil {

	private static UserAuthenticationUtil object = new UserAuthenticationUtil();

	private UserAuthenticationUtil() {
	}

	public static UserAuthenticationUtil getInstance() {
		return object;
	}

	private UserRepository userRepo = UserRepository.getInstance();

	public String userNameAndPasswordAuthenticate(HttpServletRequest req, HttpServletResponse res) throws SQLException {

		String username = req.getParameter("username");
		String givenPassword = req.getParameter("password");
		ResultSet rs = userRepo.getUserByUserName(username);
		boolean isUserPresent = false;
		boolean isPasswordValidate = false;
		String role = null;
		while (rs.next()) {
			isUserPresent = true;
			String dbPassword = rs.getString(2);
			if (givenPassword.equals(dbPassword)) {
				isPasswordValidate = true;
				role = rs.getString(3);
				break;
			}
		}

		if (isUserPresent == false)
			return "User not present with name " + username;
		if (isPasswordValidate == false)
			return "invalid password";
		Cookie cookie1=new Cookie("login",LogInstatus.VALID.getValues());
		Cookie cookie2=new Cookie("role",role);
		cookie1.setMaxAge(300);
		cookie2.setMaxAge(300);  //300sec , 5min
		res.addCookie(cookie1);
		res.addCookie(cookie2);
		HttpSession session=req.getSession();
		session.setAttribute("login",LogInstatus.VALID.getValues() );
		session.setAttribute("role",role);
		return "login success";

	}

}
