package servlets;

import models.Homework;
import models.Teacher;
import models.User;
import repositories.HomeworkRepositoryJDBCImpl;
import repositories.TeachersRepositoryJDBCImpl;
import repositories.UserRepositoryJDBCImpl;
import services.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@WebServlet("/hwCreate")
public class HWCreateServlet extends HttpServlet {
    private UserRepositoryJDBCImpl usersDao;
    private Helper helper;
    private TeachersRepositoryJDBCImpl teachersRepositoryJDBC;
    private HomeworkRepositoryJDBCImpl postDao = new HomeworkRepositoryJDBCImpl();

    @Override
    public void init() throws ServletException {
       usersDao = new UserRepositoryJDBCImpl();
        helper = new Helper();
        teachersRepositoryJDBC = new TeachersRepositoryJDBCImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        if(session.getAttribute("user") != null){
            Map<String, Object> root = new HashMap<>();
            root.put("isLogged",true);
            helper.render(req,resp,"hw_create.ftl",root);
        }else{
            resp.sendRedirect("/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        User userSession = (User)session.getAttribute("user");
        long author = userSession.getId();
        Homework homework = new Homework();
            String subject = req.getParameter("subject");
            String text = req.getParameter("text");
            String deadine = req.getParameter("deadline");
            String group = req.getParameter("group");
            homework.setDeadline(deadine);
            homework.setHw_text(text);
            homework.setSubject(subject);
            homework.setGroup_number(Integer.valueOf(group));
            homework.setMake(false);
        postDao.save(homework);

        session.setAttribute("user",userSession);
            resp.sendRedirect("/homework");

    }
}
