package pl.coderslab.session;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addToSession")
public class Session3Add extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        HttpSession session = request.getSession();

        // Pobranie listy z sesji
        List<String> names = (List<String>) session.getAttribute("names");
        // Jeśli nie było w sesji to tworzę nową listę
        if (names == null) {
            names = new ArrayList<>();
        }

        // Pobranie parametrów z requestu
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
            // Dodanie wartości do listy nazw
            names.add(key);

            // Zapisanie wartości do sesji (listy z nazwami atrybutow i sam atrybut o nazwie i wartosci z formularza)
            session.setAttribute("names", names);
            session.setAttribute(key, value);

            response.getWriter().append("Dodano wartości do sesji<br>");
            response.getWriter().append("<a href='/showAllSession'>Pokaż dane z sesji</a><br>");
            response.getWriter().append("<a href='/addToSession'>Dodaj dane</a><br>");
        } else {
            response.getWriter().append("Niepoprawne dane");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/addToSession.html");
    }
}
