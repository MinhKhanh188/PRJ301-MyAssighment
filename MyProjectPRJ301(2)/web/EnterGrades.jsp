<%-- 
    Document   : EnterGrades
    Created on : Nov 3, 2023, 3:34:04 PM
    Author     : Mr.Khanh
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Enter Grades</title>
    </head>
    <body>
        <h1>Enter Grades for Student</h1>

        <form action="GradeEntryServlet" method="post">
            <input type="hidden" name="classId" value="${param.classId}">
            <input type="hidden" name="studentId" value="${param.studentId}">

            <label for="assignment1">Assignment 1:</label>
            <input type="text" name="assignment1" required><br>

            <label for="assignment2">Assignment 2:</label>
            <input type="text" name="assignment2" required><br>

            <label for="progresstest1">Progress Test 1:</label>
            <input type="text" name="progresstest1" required><br>

            <label for="progresstest2">Progress Test 2:</label>
            <input type="text" name="progresstest2" required><br>

            <label for="FE">Final Exam:</label>
            <input type="text" name="FE" required><br>

            <label for="totalgrade">Total Grade:</label>
            <input type="text" name="totalgrade" required><br>

            <input type="submit" value="Submit">
        </form>
    </body>
</html>
