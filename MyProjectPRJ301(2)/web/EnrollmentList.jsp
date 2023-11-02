<%-- 
    Document   : EnrollmentList
    Created on : Nov 2, 2023, 3:19:53 PM
    Author     : Mr.Khanh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enrollment List</title>
</head>
<body>
    <h1>Enrollment List</h1>
    <table border="1">
        <tr>
            <th>Enrollment ID</th>
            <th>Class ID</th>
            <th>Student ID</th>
            <th>Course ID</th>
            <th>Enrollment Date</th>
        </tr>
        <c:forEach var="enrollment" items="${Enrollments}">
            <tr>
                <td>${enrollment.enrollment_id}</td>
                <td>${enrollment.class_id}</td>
                <td>${enrollment.students.student_id}</td>
                <td>${enrollment.courses.course_id}</td>
                <td>${enrollment.enrollment_date}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

