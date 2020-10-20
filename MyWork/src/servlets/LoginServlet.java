package servlets;

import models.User;
import services.Helper;
import services.LoginService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        //TODO(not done)
        resp.setContentType("text/html");
        Map<String, Object> root = new HashMap<>();
        if(userService.isUserExist(new User(email,password))){
            HttpSession session = req.getSession();
            root.put("email", email);
            helper.render(req, resp, "profile.ftl", root);

        }else{
            root.put("message","incorrect password or email");
            helper.render(req, resp, "login.ftl", root);
        }
    }

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        userService = new UserService();
        loginService = new LoginService();
        //TODO(filter and cookies)
    }
}