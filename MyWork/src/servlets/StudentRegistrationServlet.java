package servlets;

import Singletones.ConnectionProvider;
import repositories.UserRepository;
import repositories.UserRepositoryJDBCImpl;
import services.Helper;
import services.LoginService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
import java.util.Optional;


@WebServlet("/studentRegistration")
public class StudentRegistrationServlet extends HttpServlet {
    private Connection connection;
    private Helper helper;
    private LoginService loginService;
    private UserService userService;
    private Optional<String> email;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        email = userService.readCookie("email",req,resp);
        helper.render(req, resp, "registration_for_student.ftl",new HashMap<>());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Integer group = Integer.valueOf(req.getParameter("select_group"));
        //TODO(get email from cookie)
        String role ="student";
        Map<String, Object> root = new HashMap<>();
        root.put("group",group);
        root.put("role", role);

        try {
            Optional<Long> id_candidate = userService.findIdByEmail(email.get());
            if (!id_candidate.isPresent()) {
                Optional.empty();
            } else {
                Long id = id_candidate.get();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT into student (user_id, group_number) values (?,?)");
                //TODO(как вытаскивать айди юзера для табл со студентами?)
                preparedStatement.setLong(1, id);
                preparedStatement.setInt(2, group);
            }
        }catch(SQLException e){
                throw new IllegalStateException(e);
            }
            resp.sendRedirect("/hello");
            //TODO(rewrite)

    }

    @Override
    public void init() throws ServletException {
        this.userService = new UserService();
        helper = new Helper();
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = ConnectionProvider.getConnection();
        } catch (ClassNotFoundException e) {
            throw  new IllegalStateException(e);
        }
    }

}
