package com.qsp.container2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.util2.LogOutService;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {

	private LogOutService logOutService = LogOutService.getInstance();

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logOutService.logOut(req, resp);
		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		PrintWriter pw = resp.getWriter();
		pw.println("<H1> Log out Successsfull </H1>");
		rd.include(req, resp);
	}

}
