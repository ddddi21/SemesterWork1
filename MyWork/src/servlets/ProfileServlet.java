package servlets;

import models.User;
import services.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        helper = new Helper();
    }

    private Helper helper;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Map<String, Object> root = new HashMap<>();
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            root.put("isCanComeIn", true);
            resp.setContentType("text/html");
            root.put("owner",true);
            root.put("name", user.getFirstName());
            root.put("email", user.getEmail());
            root.put("role", user.getRole());
            root.put("age", user.getAge());
            root.put("imagepath", user.getImagePath());
            root.put("lastName", user.getLastName());
            if (user.getRole().equals("student")) {
                helper.render(req, resp, "profil.ftl", root);
            } else {
                if (user.getRole().equals("teacher")) {
                    helper.render(req, resp, "profilT.ftl", root);
                } else {
                    resp.sendRedirect("/home");
                }
            }
        }else resp.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String logout = req.getParameter("logout");
        if(logout != null){
            resp.sendRedirect("/logout");
        }else{
            resp.sendRedirect("/profile");
        }
    }
}
