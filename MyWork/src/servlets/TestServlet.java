package servlets;

import services.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    private Helper helper;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Map<String, Object> root = new HashMap<>();
        helper.render(req, resp, "pro.ftl", root);
    }

    @Override
    public void init() throws ServletException {
        helper = new Helper();
    }
}
