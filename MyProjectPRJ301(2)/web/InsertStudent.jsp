<%-- 
    Document   : InsertStudent
    Created on : Oct 27, 2023, 9:27:58 PM
    Author     : Mr.Khanh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert Student</title>
    </head>
    <body>
        <h2>Insert Student</h2>
        <form action="InsertStudent" method="post">
            <label for="studentID">Student ID:</label>
            <input type="number" name="studentID" id="studentID" required>
            <br>
            <label for="studentName">Student Name:</label>
            <input type="text" name="studentName" id="studentName" required>
            <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
