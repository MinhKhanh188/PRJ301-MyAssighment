/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.EnrollmentsDBConnect;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

// Your imports...

@WebServlet(name = "ClassListServlet", urlPatterns = {"/ClassListServlet"})
public class ClassListServlet extends HttpServlet {

    // Other methods...

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EnrollmentsDBConnect dbConnect = new EnrollmentsDBConnect();
    Set<Integer> uniqueClassIds = dbConnect.getUniqueClassIds();

    request.setAttribute("uniqueClassIds", uniqueClassIds);

    // Forward the request to the JSP.
    RequestDispatcher dispatcher = request.getRequestDispatcher("/ClassList.jsp");
    dispatcher.forward(request, response);
}

}



