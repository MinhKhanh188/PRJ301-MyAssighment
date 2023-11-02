<%-- 
    Document   : CourseList
    Created on : Nov 2, 2023, 4:20:38 PM
    Author     : Mr.Khanh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Courses</title>
</head>
<body>
    <h1>List of Courses</h1>
    <table border="1">
        <tr>
            <th>Course ID</th>
            <th>Subject Code</th>
            <th>Subject Name</th>
            <th>Semester</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Teacher</th>
        </tr>
        <c:forEach var="course" items="${Courselist}">
            <tr>
                <td>${course.course_id}</td>
                <td>${course.subject_Code}</td>
                <td>${course.subject_name}</td>
                <td>${course.semester}</td>
                <td>${course.start_date}</td>
                <td>${course.end_date}</td>
                <td>${course.teachers != null ? course.teachers.teacher_name : 'N/A'}</td>


            </tr>
        </c:forEach>
    </table>
</body>
</html>

