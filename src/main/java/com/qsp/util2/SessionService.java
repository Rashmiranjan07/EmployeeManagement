package com.qsp.util2;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionService {
	private static SessionService object = new SessionService();

	private SessionService() {

	}

	public static SessionService getInstancce() { 
		return object;
	}

	public boolean validateSession(ServletRequest req) {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		Object object = session.getAttribute("login");
		if (object == null)
			return false;
		String status = (String) object;
		return status.equals(LogInstatus.VALID.getValues());

	}

}
