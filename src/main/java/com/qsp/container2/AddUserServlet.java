package com.qsp.container2;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.repository2.UserRepository;



@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {

	private UserRepository userRepo = UserRepository.getInstance();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		String role = req.getParameter("role");
		if (role == null || role.isEmpty()) {
			req.setAttribute("error", "role is empty");
			rd.forward(req, resp);
			return;
		}
		System.out.println(username + " " + role + " " + password);

		String response = userRepo.adduser(username, password, role);
		String text = "<H1>" + response + "</H1>";
		PrintWriter pw = resp.getWriter();
		pw.println(text);
	}

}
