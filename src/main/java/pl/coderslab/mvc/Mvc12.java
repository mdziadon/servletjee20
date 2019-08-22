package pl.coderslab.mvc;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc12")
public class Mvc12 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");

        if (!StringUtils.isNumeric(start) || !StringUtils.isNumeric(end)) {
            response.getWriter().append("Niepoprawne parametry: start, end");
            return;
        }

        int startInt = Integer.parseInt(start);
        int endInt = Integer.parseInt(end);

        if (startInt >= endInt) {
            response.getWriter().append("Parametr start jest większy lub równy end");
            return;
        }

        request.setAttribute("start", startInt + 10);
        request.setAttribute("end", endInt + 10);

        getServletContext().getRequestDispatcher("/jsp2.jsp")
                .forward(request, response);
    }
}
