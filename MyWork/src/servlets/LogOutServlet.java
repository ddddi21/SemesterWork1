package servlets;

import models.User;
import services.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    private Helper helper;
    Map<String, Object> root = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            root.put("isCanComeIn", false);
            root.put("message", "sign in!");
            helper.render(req, resp, "login.ftl",root);

        } else {
            session.removeAttribute("user");
            if(cookies != null) {
                for (Cookie cookie : cookies) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
            resp.sendRedirect("/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }

    @Override
    public void init() throws ServletException {
        helper = new Helper();
    }
}
