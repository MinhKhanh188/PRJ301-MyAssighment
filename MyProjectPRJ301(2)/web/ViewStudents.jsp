<%-- 
    Document   : ViewStudents
    Created on : Nov 2, 2023, 10:13:37 PM
    Author     : Mr.Khanh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Students in Class</title>
</head>
<body>
    <h1>Students in Class ${classId}</h1>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
        </tr>
        <c:forEach var="student" items="${studentsInClass}">
            <tr>
                <td>${student.student_id}</td>
                <td>${student.student_name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

