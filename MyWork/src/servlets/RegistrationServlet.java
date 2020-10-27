package servlets;

import singletones.ConnectionProvider;
import models.User;
import services.Helper;
import services.UserService;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private Connection connection;
    private Helper helper;
    private UserService userService;
    Map<String, Object> root = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
                root.put("isCanComeIn", false);
                helper.render(req, resp, "registration.ftl",root);
        } else resp.sendRedirect("/profile");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String role = req.getParameter("role");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String age = req.getParameter("age");

        //TODO(check correct (not empty) fields)

        root.put("name", firstName);
        root.put("last_name", lastName);
        root.put("age", age);
        root.put("email", email);

        //TODO(add custom exception)
        //TODO(add hash to password)

        if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || age.isEmpty() ||role==null){
            root.put("message", "Empty fields!");
            helper.render(req, resp, "registration.ftl", root);
        }else {
            if(userService.isAlreadyHaveAccount(email)){
                writer.write("you already have an account! Please sign in");
                //TODO(текст кароч не отображается но пофег пока)
                resp.sendRedirect("/login");
            }else {
                User user = new User(firstName,lastName,Integer.parseInt(age),email,password,role);
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
            }

      }

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
