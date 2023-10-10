<%-- 
    Document   : RegisterStudent
    Created on : Oct 10, 2023, 8:20:50 PM
    Author     : Mr.Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information Form</title>
</head>
<body>
    <h2>Student Information Form</h2>
    <form action="process_form.php" method="POST">
        <!-- Input for student_id (assuming it's an integer) -->
        <label for="student_id">Student ID:</label>
        <input type="number" id="student_id" name="student_id" required><br><br>
        
        <!-- Input for student_name (assuming it's a text field) -->
        <label for="student_name">Student Name:</label>
        <input type="text" id="student_name" name="student_name" required><br><br>
        
        <!-- Input for student_major (assuming it's a text field) -->
        <label for="student_major">Student Major:</label>
        <input type="text" id="student_major" name="student_major" required><br><br>
        
        <!-- Input for student_gender (assuming it's a radio button) -->
        <label>Gender:</label><br>
        <input type="radio" id="male" name="student_gender" value="Male" required>
        <label for="male">Male</label><br>
        <input type="radio" id="female" name="student_gender" value="Female" required>
        <label for="female">Female</label><br><br>
        
        <!-- Input for student_dob (assuming it's a date input) -->
        <label for="student_dob">Date of Birth:</label>
        <input type="date" id="student_dob" name="student_dob" required><br><br>
        
        <!-- Submit button to submit the form -->
        <input type="submit" value="Submit">
    </form>
</body>
</html>
