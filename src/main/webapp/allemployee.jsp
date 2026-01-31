<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.qsp.repository2.EmployeeRepository" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees</title>

<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap');

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

body {
    min-height: 100vh;
    background:
        radial-gradient(circle at top left, #fbc2eb, transparent 40%),
        radial-gradient(circle at bottom right, #a6c1ee, transparent 40%),
        linear-gradient(135deg, #e0eafc, #cfdef3);
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 20px;
}

/* Main Card */
.card {
    width: 100%;
    max-width: 900px;
    background: rgba(255, 255, 255, 0.55);
    backdrop-filter: blur(20px);
    border-radius: 26px;
    box-shadow: 0 30px 70px rgba(0,0,0,0.2);
    overflow: hidden;
    animation: slideFade 0.8s ease;
}

/* Header */
.header {
    padding: 40px 30px 60px;
    text-align: center;
    background: linear-gradient(120deg, #667eea, #764ba2);
    color: white;
}

.header h1 {
    font-size: 30px;
    font-weight: 600;
    letter-spacing: 1px;
}

.header span {
    font-size: 14px;
    opacity: 0.9;
}

/* Avatar */
.avatar-wrap {
    display: flex;
    justify-content: center;
    margin-top: -45px;
}

.avatar {
    width: 90px;
    height: 90px;
    border-radius: 50%;
    background: linear-gradient(135deg, #ff9a9e, #fad0c4);
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 36px;
    box-shadow: 0 12px 30px rgba(0,0,0,0.35);
}

/* Content */
.content {
    padding: 40px;
}

/* Table */
table {
    width: 100%;
    border-collapse: separate;
    border-spacing: 0 14px;
}

thead td {
    font-weight: 600;
    color: #555;
    padding-bottom: 10px;
}

tr {
    background: rgba(255,255,255,0.7);
    border-radius: 14px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.08);
}

td {
    padding: 16px 18px;
    color: #222;
    font-size: 14px;
}

tr td:first-child {
    border-top-left-radius: 14px;
    border-bottom-left-radius: 14px;
}

tr td:last-child {
    border-top-right-radius: 14px;
    border-bottom-right-radius: 14px;
}

/* Buttons */
a {
    text-decoration: none;
    padding: 8px 14px;
    border-radius: 20px;
    font-size: 13px;
    font-weight: 500;
    transition: all 0.3s ease;
}

.update {
    background: linear-gradient(120deg, #667eea, #764ba2);
    color: white;
}

.update:hover {
    opacity: 0.85;
}

.delete {
    background: linear-gradient(120deg, #ff758c, #ff7eb3);
    color: white;
}

.delete:hover {
    opacity: 0.85;
}

/* Footer */
.footer {
    text-align: center;
    padding: 18px;
    font-size: 13px;
    color: #555;
    background: rgba(255,255,255,0.5);
}

/* Animation */
@keyframes slideFade {
    from {
        opacity: 0;
        transform: translateY(40px) scale(0.96);
    }
    to {
        opacity: 1;
        transform: translateY(0) scale(1);
    }
}

/* Mobile */
@media (max-width: 700px) {
    table, thead, tbody, tr, td {
        display: block;
        width: 100%;
    }

    thead {
        display: none;
    }

    tr {
        padding: 12px;
    }

    td {
        padding: 10px 12px;
    }
}
</style>
</head>

<body>

<%
    EmployeeRepository employeerepo = EmployeeRepository.getInstance();
    ResultSet rs = employeerepo.getAllEmployee();
%>

<div class="card">

    <div class="header">
        <h1>All Employees</h1>
        <span>Clean • Elegant • Professional</span>
    </div>

    <div class="avatar-wrap">
        <div class="avatar">💼</div>
    </div>

    <div class="content">
        <table>
            <thead>
                <tr>
                    <td>Name</td>
                    <td>Age</td>
                    <td>Phone</td>
                    <td>Email</td>
                    <td>Update</td>
                    <td>Delete</td>
                </tr>
            </thead>

            <tbody>
            <%
                while (rs != null && rs.next()) {
            %>
                <tr>
                    <td><%= rs.getString(1) %></td>
                    <td><%= rs.getInt(2) %></td>
                    <td><%= rs.getString(3) %></td>
                    <td><%= rs.getString(4) %></td>
                    <td>
                        <a class="update" href="updateemployee?email=<%= rs.getString(4) %>">Update</a>
                    </td>
                    <td>
                        <a class="delete" href="deleteemployee?email=<%= rs.getString(4) %>">Delete</a>
                    </td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

    <div class="footer">
        ✨ Employee Management System · 2026
    </div>

</div>

</body>
</html>
