package servlets;

import Singletones.ConnectionProvider;
import models.Teacher;
import models.User;
import services.Helper;
import services.LoginService;
import services.TeacherService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;


@WebServlet("/teacherRegistration")
public class TeacherRegistrationServlet extends HttpServlet {
    private Connection connection;
    private Helper helper;
    private Optional<String> email;
    private UserService userService;
    private TeacherService teacherService;
    Map<String, Object> root = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        email = userService.readCookie("email",req,resp);
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            root.put("isCanComeIn", false);
            helper.render(req, resp, "registration_for_teacher.ftl",root);
        } else helper.render(req, resp, "profile.ftl",root);    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String role = "teacher";
        String subjects = req.getParameter("select_subject");
        Map<String, Object> root = new HashMap<>();
        root.put("role", role);
        root.put("email", email.get());
        //TODO(add select groups)

        Optional<Long> id_candidate = userService.findIdByEmail(email.get());
        if (!id_candidate.isPresent()) {
            Optional.empty();
            root.put("message","incorrect password or email");
            helper.render(req, resp, "login.ftl", root);
        } else {
            Long id = id_candidate.get();
            teacherService.save(new Teacher(id,subjects));
            root.put("message", "You create a new account!");
            helper.render(req, resp, "login.ftl", root);
        }
        //TODO(rewrite)
        //TODO(rewrite)

    }

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        teacherService = new TeacherService();
        userService = new UserService();
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = ConnectionProvider.getConnection();
        } catch (ClassNotFoundException e) {
            throw  new IllegalStateException(e);
        }
           }
}
