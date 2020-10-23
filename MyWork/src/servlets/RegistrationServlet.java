package servlets;

import Singletones.ConnectionProvider;
import models.User;
import services.Helper;
import services.LoginService;
import services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private Connection connection;
    private Helper helper;
    private LoginService loginService;
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        helper.render(req, resp, "registration.ftl",new HashMap<>());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String role = req.getParameter("role");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Integer age = Integer.valueOf(req.getParameter("age"));
        Map<String, Object> root = new HashMap<>();

        //TODO(check correct (not empty) fields)

        root.put("name", firstName);
        root.put("last_name", lastName);
        root.put("age", age);
        root.put("email", email);

        //TODO(add custom exception)
        //TODO(add hash to password)

        User user = new User(firstName,lastName,age,email,password,role);
//        if(userService.isAlreadyHaveAccount(email)){
//            root.put("message", "you already have an account! Please sign in");
//            helper.render(req, resp, "login.ftl", root);
//        }else {
            userService.save(user);


            Cookie cookie_email = new Cookie("email", email);
            cookie_email.setMaxAge(-1);
            resp.addCookie(cookie_email);

            if (role.equals("teacher")) {
                resp.sendRedirect("/teacherRegistration");
            } else {
                if (role.equals("student")) {
                    resp.sendRedirect("/studentRegistration");
                }
            }
        }

//      }

    @Override
    public void init(ServletConfig config) throws ServletException {
         helper = new Helper();
         userService = new UserService();
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = ConnectionProvider.getConnection();
        } catch (ClassNotFoundException e) {
            throw  new IllegalStateException(e);
        }
    }
}
