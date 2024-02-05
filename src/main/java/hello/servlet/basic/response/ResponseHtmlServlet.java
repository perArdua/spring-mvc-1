package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Content-Type: text/html;charset=utf-8
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("<html>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("  <div>안녕?</div>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
