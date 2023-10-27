<%-- 
    Document   : StudentList
    Created on : Oct 27, 2023, 8:54:57 PM
    Author     : Mr.Khanh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information</title>
</head>
<body>
    <h2>Student Information</h2> 
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
        </tr>
        <c:forEach var="student" items="${students}">

            <tr>
                <td><c:out value="${student.student_id}" /></td>
                <td><c:out value="${student.student_name}" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

