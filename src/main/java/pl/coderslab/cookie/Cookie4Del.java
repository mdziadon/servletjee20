package pl.coderslab.cookie;

import org.apache.commons.lang3.ArrayUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeCookie")
public class Cookie4Del extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String cookieName = request.getParameter("cookieName");

        Cookie[] cookies = request.getCookies();

        if (ArrayUtils.isEmpty(cookies)) {
            response.getWriter().append("Brak ciasteczek");
            return;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                response.getWriter().append("Ciasteczko ")
                        .append(cookieName)
                        .append(" zostalo usuniete")
                        .append("<br><br>")
                        .append("<a href='/showAllCookies'>Powrót</a>");
            }
        }
    }
}
