package com.qsp.container2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.util2.UserAuthenticationUtil;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {

	private UserAuthenticationUtil userAuth = UserAuthenticationUtil.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/emptydata");
		String username = req.getParameter("username");
		if (username == null || username.isEmpty()) {
			req.setAttribute("error", "username is empty");
			rd.forward(req, resp);
			return;
		}
		String password = req.getParameter("password");
		if (password == null || password.isEmpty()) {
			req.setAttribute("error", "password is empty");
			rd.forward(req, resp);
			return;
		}

		String response = "Some unexpected error created";

		try {
			response = userAuth.userNameAndPasswordAuthenticate(req, resp);
		} catch (Exception e) {
			e.printStackTrace();

		}

		PrintWriter pw = resp.getWriter();
		String text = "<H1>" + response + "</h1>";
		pw.println(text);

	}

}
