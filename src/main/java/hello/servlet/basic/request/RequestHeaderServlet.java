package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);
    }

    private void printStartLine(HttpServletRequest req) {
        System.out.println("--- REQUEST-LINE - start ---");

        System.out.println("req.getMethod() = " + req.getMethod()); // GET
        System.out.println("req.getProtocol() = " + req.getProtocol()); // HTTP/1.1
        System.out.println("req.getScheme() = " + req.getScheme()); // http

        System.out.println("req.getRequestURL() = " + req.getRequestURL()); // http://localhost:8080/request-header
        System.out.println("req.getRequestURI() = " + req.getRequestURI()); // /request-test
        System.out.println("req.getQueryString() = " + req.getQueryString()); // username=hi

        System.out.println("req.isSecure() = " + req.isSecure()); // false
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("--- Headers - start ---");

        req.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " + req.getHeader(headerName)));

        System.out.println("--- Headers - end ---");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest req) {
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("req.getServerName() = " + req.getServerName()); // Host 헤더
        System.out.println("req.getServerPort() = " + req.getServerPort()); // Host 헤더
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("req.getLocale() = " + req.getLocale());
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if (req.getCookies() != null) {
            for (var cookie : req.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("req.getContentType() = " + req.getContentType());
        System.out.println("req.getContentLength() = " + req.getContentLength());
        System.out.println("req.getCharacterEncoding() = " + req.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }
}
