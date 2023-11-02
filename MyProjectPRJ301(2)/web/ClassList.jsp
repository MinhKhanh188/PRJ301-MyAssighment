<%-- 
    Document   : ClassList
    Created on : Nov 2, 2023, 9:47:54 PM
    Author     : Mr.Khanh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>List of Classes</title>
    </head>
    <body>
        <h1>List of Classes</h1>
        <table border="1">
            <tr>
                <th>Class ID</th>
                <th>Action</th>
            </tr>
            <c:forEach var="classId" items="${uniqueClassIds}">
                <tr>
                    <td>${classId}</td>
                    <td><a href="ViewStudents?classId=${classId}">View Students</a></td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>

