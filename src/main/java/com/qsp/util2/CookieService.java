package com.qsp.util2;



import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieService {
	private static final CookieService object = new CookieService();

	private CookieService() {
	}

	public static CookieService getInstance() {
		return object;
	}

	public static boolean validateCookies(ServletRequest req) {
		HttpServletRequest request = (HttpServletRequest) req;
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 0)
			return false;

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login") && cookie.getValue().equals(LogInstatus.VALID.getValues())) {
				return true;
			}
		}
		return false;
	}
}


