package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addToCookies")
public class Cookie2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cookieName = request.getParameter("key");
        String cookieValue = request.getParameter("value");
        String time = request.getParameter("time");

        // todo sprawdzenie poprawności danych

        Cookie cookie = new Cookie(cookieName, cookieValue);
        int timeInt = Integer.parseInt(time);
        cookie.setMaxAge(timeInt * 60 * 60);
        response.addCookie(cookie);

        response.getWriter().append("Ciasteczko dodane");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/cookie2.html");
    }
}
