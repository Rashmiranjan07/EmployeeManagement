package com.qsp.util2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutService {

	private static LogOutService object = new LogOutService();

	private LogOutService() {
	}

	public static LogOutService getInstance() {
		return object;
	}

	public void logOut(HttpServletRequest request, HttpServletResponse response) {
		// invalidate the session
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		// invalidate cookies
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 0)
			return;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login") || cookie.getName().equals("role")) {
//				cookie.setPath("/");
				cookie.setValue("");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}

	}

}
