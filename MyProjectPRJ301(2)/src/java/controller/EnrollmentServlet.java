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
import model.Enrollments;

/**
 *
 * @author Mr.Khanh
 */
@WebServlet(name = "EnrollmentServlet", urlPatterns = {"/EnrollmentServlet"})
public class EnrollmentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int enrollment_id = Integer.parseInt(request.getParameter("enrollment_id"));
            int class_id = Integer.parseInt(request.getParameter("class_id"));
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            int course_id = Integer.parseInt(request.getParameter("course_id"));
            String enrollment_date = request.getParameter("enrollment_date");

            Enrollments enrollments = new Enrollments(enrollment_id, class_id, student_id, course_id, enrollment_date);

            EnrollmentsDBConnect dBConnect = new EnrollmentsDBConnect();

            dBConnect.enrollmentInsert(enrollments);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EnrollmentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EnrollmentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }



    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
