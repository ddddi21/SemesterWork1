package servlets;

import Singletones.ConnectionProvider;
import services.Helper;
import services.LoginService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO " + "all_user(first_name, last_name, age, role, email, password) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setInt(3,age);
            preparedStatement.setString(4,role);
            preparedStatement.setString(5,email);
            //TODO(add custom exception)
            preparedStatement.setString(6,password);
            //TODO(add hash)
            preparedStatement.execute();
            //TODO(create tables S and T and add into them)
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        if(role.equals("teacher")){
            resp.sendRedirect("/teacherRegistration");
//            List subjects = Collections.singletonList(req.getParameter("select_subject"));
//            TODO(перетащить в другой серлвет)
        } else{
            if(role.equals("student")){
                resp.sendRedirect("/studentRegistration");
            }
        }


      }

    @Override
    public void init(ServletConfig config) throws ServletException {
         helper = new Helper();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw  new IllegalStateException(e);
        }
        this.connection = ConnectionProvider.getConnection();
    }
}
