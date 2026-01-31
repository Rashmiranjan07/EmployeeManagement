<%@page import="java.sql.ResultSet"%>
<%@page import="com.qsp.repository2.EmployeeRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employee Data</title>
</head>
<body>

	<h1>All Employee Data</h1>

	<%!EmployeeRepository employeerepo = EmployeeRepository.getInstance();%>

	<table>
		<thead>
			<tr>
				<td>name</td>
				<td>age</td>
				<td>phone</td>
				<td>email</td>
				<td>Update</td>
				<td>Delete</td>
			</tr>
		</thead>

		<tbody>
			<%
			ResultSet rs = employeerepo.getAllEmployee(); // method name example
			if (rs == null)
				return;

			while (rs.next()) {
			%>

			<tr>
				<td><%= rs.getString(1) %></td>
				<td><%= rs.getInt(2) %></td>
				<td><%= rs.getString(3) %></td>
				<td><%= rs.getString(4) %></td>

				<td>
					<a href="updateemployee?email=<%= rs.getString(4) %>">update</a>
				</td>
				<td>
					<a href="deleteemployee?email=<%= rs.getString(4) %>">delete</a>
				</td>
			</tr>

			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>
