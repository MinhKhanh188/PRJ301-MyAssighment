<%-- 
    Document   : StudentList
    Created on : Oct 14, 2023, 11:44:18 AM
    Author     : Mr.Khanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Students</title>
</head>
<body>
    <h1>List of Students</h1>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.student_id}</td>
                <td>${student.student_name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
