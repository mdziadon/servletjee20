package pl.coderslab.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mvc15")
public class Mvc15 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<Book> books = (List<Book>) session.getAttribute("books");
        if (books == null) {
            books = new ArrayList<>();
        }

        String[] titles = request.getParameterValues("title");
        String[] authors = request.getParameterValues("author");
        String[] isbns = request.getParameterValues("isbn");

        for (int i = 0; i < titles.length ; i++) {
            Book book = new Book(titles[i], authors[i], isbns[i]);
            books.add(book);
        }

        session.setAttribute("books", books);

        request.setAttribute("added", "true");

        doGet(request, response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp4.jsp")
                .forward(request, response);
    }
}
