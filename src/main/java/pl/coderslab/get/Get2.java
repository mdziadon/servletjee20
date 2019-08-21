package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

// http://localhost:8080/get2?param=1&param=2&param=3&a=1&b=2&c=20&c=10

@WebServlet("/get2")
public class Get2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
            response.getWriter().append("Wartości dla parametru: ").append(key).append("<br>");
            String[] values = map.get(key);
            String valuesStr = Arrays.toString(values);
            response.getWriter().append(valuesStr).append("<br>");
        }

    }
}
