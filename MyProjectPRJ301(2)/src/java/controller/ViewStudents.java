/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.EnrollmentsDBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Students;

/**
 *
 * @author Mr.Khanh
 */
@WebServlet(name="ViewStudents", urlPatterns={"/ViewStudents"})
public class ViewStudents extends HttpServlet {
   
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    int classId = Integer.parseInt(request.getParameter("classId"));
    
    // Retrieve students in the specified class using your data access class
    EnrollmentsDBConnect dbConnect = new EnrollmentsDBConnect();
    List<Students> studentsInClass = dbConnect.getStudentsInClass(classId);
    
    request.setAttribute("classId", classId);
    request.setAttribute("studentsInClass", studentsInClass);
    request.getRequestDispatcher("/ViewStudents.jsp").forward(request, response);
}

}
