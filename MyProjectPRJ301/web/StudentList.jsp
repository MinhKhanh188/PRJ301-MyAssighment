<%-- 
    Document   : StudentList
    Created on : Oct 14, 2023, 11:44:18 AM
    Author     : Mr.Khanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                border: 1px solid #000;
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
        </style>
        
        <script >
            function removeStudent(id)
            {
                var result = confirm("Are you sure?");
                if(result)
                {
                    window.location.href= 'RemoveServlet?id='+id;
                }
            }
            
        </script>
    </head>
    <body>
        <table>
            <tr>
                <th>Name</th>
                <th>Gender</th>
                <th>Date of Birth</th>
                <th>Department</th>
                <th></th>
            </tr>
            <c:forEach items="${requestScope.students}" var="s">
            <tr>
                <td>${s.name}</td>
                <td>${s.gender?"Male":"Female"}</td>
                <td>${s.dob}</td>
                <td>${s.dept.name}</td>
                <td><a href="EditServlet?id=${s.id}">Edit</a>
                    <input type="button" value="Remove" onclick="removeStudent(${s.id})"/>
                </td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>

