package servlets;

import Singletones.ConnectionProvider;
import services.Helper;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/teacherRegistration")
public class TeacherRegistrationServlet extends HttpServlet {
    private Connection connection;
    private Helper helper;
    private LoginService loginService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        helper.render(req, resp, "registration_for_teacher.ftl",new HashMap<>());    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String role = "student";
        List subjects = Collections.singletonList(req.getParameter("select_subject"));

        Map<String, Object> root = new HashMap<>();

//        root.put("name", firstName);
//        root.put("last_name", lastName);
//        root.put("age", age);
//        root.put("email", email);
        root.put("role", role);
        //TODO(rewrite)
        try {
            PreparedStatement find_id_ps = connection.prepareStatement("SELECT * FROM all_user WHERE email = ?");
//            find_id_ps.setString(1,email2);
            ResultSet result = find_id_ps.executeQuery();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO " + "teacher_subject(math, english, it, geography) VALUES (?,?,?,?)");
//            preparedStatement.setInt(1,result,);
            //TODO(ASK как вытаскивать айди юзера для табл со студентами?)
//            switch (subjects) {
//               case ("math")
//                       preparedStatement.setInt(1, subjects);
//            }
            //TODO(ASK как добавлять в бд лист предметов в буленовские колонны)
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        resp.sendRedirect("/hello");
        //TODO(rewrite)

    }

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw  new IllegalStateException(e);
        }
        this.connection = ConnectionProvider.getConnection();    }
}
