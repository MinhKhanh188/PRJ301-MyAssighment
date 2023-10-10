<%-- 
    Document   : insertGrade
    Created on : Oct 10, 2023, 7:49:28 PM
    Author     : Mr.Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Grade Input Form</title>
</head>
<body>
    <h2>Student Grade Input Form</h2>
    <form id="gradeForm">
        <label for="assignment1">Assignment 1:</label>
        <input type="number" id="assignment1" name="assignment1" step="any" required><br><br>

        <label for="assignment2">Assignment 2:</label>
        <input type="number" id="assignment2" name="assignment2" step="any" required><br><br>

        <label for="progresstest1">Progress Test 1:</label>
        <input type="number" id="progresstest1" name="progresstest1" step="any" required><br><br>

        <label for="progresstest2">Progress Test 2:</label>
        <input type="number" id="progresstest2" name="progresstest2" step="any" required><br><br>

        <div id="totalGradeDiv" style="display: none;">
            <label for="totalgrade">Total Grade:</label>
            <span id="totalgrade"></span><br><br>
        </div>

        <input type="submit" value="Submit">
    </form>

    <script>
        const gradeForm = document.getElementById("gradeForm");
        const totalGradeDiv = document.getElementById("totalGradeDiv");
        const totalGradeSpan = document.getElementById("totalgrade");

        gradeForm.addEventListener("submit", function (e) {
            e.preventDefault();
            const assignment1 = parseFloat(document.getElementById("assignment1").value);
            const assignment2 = parseFloat(document.getElementById("assignment2").value);
            const progresstest1 = parseFloat(document.getElementById("progresstest1").value);
            const progresstest2 = parseFloat(document.getElementById("progresstest2").value);

            if (!isNaN(assignment1) && !isNaN(assignment2) && !isNaN(progresstest1) && !isNaN(progresstest2)) {
                const total = (assignment1 + assignment2 + progresstest1 + progresstest2).toFixed(2);
                totalGradeSpan.textContent = total;
                totalGradeDiv.style.display = "block";
            } else {
                alert("Please enter valid grades for all fields.");
            }
        });
    </script>
</body>
</html>

