package com.qsp.filter2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.qsp.util2.CookieService;
import com.qsp.util2.SessionService;

@WebFilter(urlPatterns = { "/addemployee", "/adduser" })
public class requestAuthenticationFilter implements Filter {

	private CookieService cookieService = CookieService.getInstance();
	private SessionService sessionService = SessionService.getInstancce();

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Security filter activated");
		if (CookieService.validateCookies(request) || sessionService.validateSession(request)) {
			chain.doFilter(request, response);
			return;

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			return;
		}

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}
}
