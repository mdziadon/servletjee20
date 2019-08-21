package pl.coderslab.post;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post2")
public class Form2 extends HttpServlet {

    private final static String[] BAD_WORDS = {"kurde", "motylanoga", "cholera"};

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        String agree = request.getParameter("agree");

        if (!"on".equals(agree)) {
           for (String word : BAD_WORDS) {
               if (text.contains(word)) {
                   String stars = word.replaceAll(".", "*");
                   text = StringUtils.replace(text, word, stars);
               }
           }

        }

        response.getWriter().append(text);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/form2.html");
    }
}
