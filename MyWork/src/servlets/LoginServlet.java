package servlets;

import models.User;
import org.mindrot.jbcrypt.BCrypt;
import services.Helper;
import services.LoginService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private Helper helper;
    private LoginService loginService;
    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        helper.render(req, resp, "login.ftl",new HashMap<>());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String remember = req.getParameter("remember");
        //TODO(not done)
        resp.setContentType("text/html");
        Map<String, Object> root = new HashMap<>();

        if(email.isEmpty() || password.isEmpty()){
            root.put("message", "Empty fields!");
            helper.render(req, resp, "login.ftl", root);
        } else {
            if (userService.login(email, password)) {
                if (remember != null) {
                    Cookie cookieForAuth = new Cookie("cookieForAuth", email);
                    cookieForAuth.setMaxAge(-1);
                    resp.addCookie(cookieForAuth);
                }
                HttpSession session = req.getSession();
                User user = userService.findUserByEmail(email).get();
                //TODO(создать препода/студента с помощью методов jdbc который нужно сделать)
                session.setAttribute("user", user);
                root.put("email", email);
                root.put("name", user.getFirstName());
                root.put("role", user.getRole());
                root.put("age", user.getAge());
                root.put("lastName", user.getLastName());
                //TODO(в зависимости от препод/ученик сделать разный рендер профилей + сделать шаблоны к ним + положить в рут персональные параметры)
                resp.sendRedirect("/profile");

            } else {
                root.put("message", "incorrect password or email");
                helper.render(req, resp, "login.ftl", root);
            }
        }
    }

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        userService = new UserService();
        loginService = new LoginService();
    }
}