package pl.coderslab.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/mvc15show")
public class Mvc15show extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Book> books = (List<Book>) session.getAttribute("books");

        if (books == null || books.size() ==  0) {
            response.getWriter().append("Brak książek w sesji");
            return;
        }

        request.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/resultList.jsp")
                .forward(request, response);
    }
}
