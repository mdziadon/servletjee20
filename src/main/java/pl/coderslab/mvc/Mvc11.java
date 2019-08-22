package pl.coderslab.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc11")
public class Mvc11 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String role = request.getParameter("role");
//        request.setAttribute("role", role);
        request.setAttribute("test", "test123");
        getServletContext().getRequestDispatcher("/jsp1.jsp")
                .forward(request, response);
    }
}
