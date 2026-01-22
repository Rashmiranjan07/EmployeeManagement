package com.qsp.container2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emptydata")
public class EmptyDataServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Empty data came");
		String message = (String) req.getAttribute("error");
		System.out.println(message);
		PrintWriter pw = resp.getWriter();
		String response = "<H1>" + message + "</H1>";
		pw.println(response);

	}

}
