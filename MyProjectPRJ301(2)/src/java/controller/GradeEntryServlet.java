/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.GradesDBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Grades;

/**
 *
 * @author Mr.Khanh
 */
@WebServlet(name="GradeEntryServlet", urlPatterns={"/GradeEntryServlet"})
public class GradeEntryServlet extends HttpServlet {
   
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form data from the request.
        int classId = Integer.parseInt(request.getParameter("classId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        double assignment1 = Double.parseDouble(request.getParameter("assignment1"));
        double assignment2 = Double.parseDouble(request.getParameter("assignment2"));
        double progresstest1 = Double.parseDouble(request.getParameter("progresstest1"));
        double progresstest2 = Double.parseDouble(request.getParameter("progresstest2"));
        double FE = Double.parseDouble(request.getParameter("FE"));
        double totalgrade = Double.parseDouble(request.getParameter("totalgrade"));

        // Create a new Grades object with the form data.
        Grades grade = new Grades();
        grade.setStudent_id(studentId);
        grade.setEnrollment_id(classId);
        grade.setAssignment1(assignment1);
        grade.setAssignment2(assignment2);
        grade.setProgresstest1(progresstest1);
        grade.setProgresstest2(progresstest2);
        grade.setFE(FE);
        grade.setTotalgrade(totalgrade);

        // Insert the grades into the database.
        GradesDBConnect dbConnect = new GradesDBConnect();
        dbConnect.GradesInsert(grade);

        // You can add additional logic for success or error handling here.
    }
}