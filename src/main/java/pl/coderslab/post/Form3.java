package pl.coderslab.post;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getForm3")
public class Form3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        if (!StringUtils.isNumeric(page)) {
            response.getWriter().append("Niepoprawny parametr");
            return;
        }

        int pageInt = Integer.parseInt(page);
        response.getWriter().append("Dzielniki liczby ").append(String.valueOf(pageInt)).append(": ");
        for (int i = 1; i <= (pageInt / 2); i++) {
            if (pageInt % i == 0) {
                response.getWriter().append("" + i + ", ");
            }
        }
        response.getWriter().append(page);
    }
}
