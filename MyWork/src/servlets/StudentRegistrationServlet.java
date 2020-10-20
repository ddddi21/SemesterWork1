package servlets;

import Singletones.ConnectionProvider;
import repositories.UserRepository;
import repositories.UserRepositoryJDBCImpl;
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
import java.util.HashMap;
import java.util.Map;


@WebServlet("/studentRegistration")
public class StudentRegistrationServlet extends HttpServlet {
    private UserRepositoryJDBCImpl userRepositoryJDBC;
    private Connection connection;
    private Helper helper;
    private LoginService loginService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        helper.render(req, resp, "registration_for_student.ftl",new HashMap<>());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Integer group = Integer.valueOf(req.getParameter("select_group"));
        //TODO(get email from cookie)
//        String id= userRepositoryJDBC.findIdByEmail();
        String role ="student";
        Map<String, Object> root = new HashMap<>();
        root.put("group",group);
        root.put("role", role);
        try {
            PreparedStatement find_id_ps = connection.prepareStatement("SELECT * FROM all_user WHERE email = ?");
//            find_id_ps.setString(1,email2);
            ResultSet result = find_id_ps.executeQuery();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO " + "student(group_number) VALUES (?)");
//            preparedStatement.setInt(1,result,);
            //TODO(как вытаскивать айди юзера для табл со студентами?)
            preparedStatement.setInt(1,group);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        resp.sendRedirect("/hello");
        //TODO(rewrite)

    }

    @Override
    public void init() throws ServletException {
        this.userRepositoryJDBC = new UserRepositoryJDBCImpl();
        helper = new Helper();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw  new IllegalStateException(e);
        }
        this.connection = ConnectionProvider.getConnection();    }
}
