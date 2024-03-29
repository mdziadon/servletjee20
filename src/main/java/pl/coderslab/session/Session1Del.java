package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session1Del")
public class Session1Del extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("counter") == null) {
            response.getWriter().append("Brak atrybutu counter w sesji");
        } else {
            session.removeAttribute("counter");
            response.getWriter().append("Atrybut counter usuniety z sesji");
        }
    }
}
