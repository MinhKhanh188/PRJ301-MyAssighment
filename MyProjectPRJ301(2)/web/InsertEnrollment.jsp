<%-- 
    Document   : InsertEnrollment
    Created on : Nov 1, 2023, 10:18:09 AM
    Author     : Mr.Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Enrollment Form</title>
    </head>
    <body>
        <h2>Enrollment Form</h2>
        <form action="EnrollmentServlet" method="post">
            Enrollment ID: <input type="text" name="enrollment_id"><br>
            Student ID: <input type="text" name="student_id"><br>
            Course ID: <input type="text" name="course_id"><br>
            Enrollment Date: <input type="date" name="enrollment_date"><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>

