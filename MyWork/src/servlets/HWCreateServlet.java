package servlets;

import models.Homework;
import models.Teacher;
import models.User;
import repositories.HomeworkRepositoryJDBCImpl;
import repositories.TeachersRepositoryJDBCImpl;
import repositories.UserRepositoryJDBCImpl;
import services.Helper;
import services.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@WebServlet("/hwCreate")
public class HWCreateServlet extends HttpServlet {
    private Helper helper;
    private TeacherService teacherService;
    private HomeworkRepositoryJDBCImpl homeworkRepositoryJDBC = new HomeworkRepositoryJDBCImpl();

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        teacherService = new TeacherService();
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
            helper.render(req,resp,"hw_create2.ftl",root);
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
        Optional <Teacher> teacher = teacherService.findByUserOd(userSession.getId());
        Homework homework = new Homework();
        if(teacher.isPresent()){
            homework.setSubject(teacher.get().getSubject());
            homework.setGroup_number(teacher.get().getGroups());
        }else {
            throw new IllegalStateException();
        }
            String text = req.getParameter("text");
            String deadine = req.getParameter("deadline");
            homework.setDeadline(deadine);
            homework.setHw_text(text);
            homework.setMake(false);
        homeworkRepositoryJDBC.save(homework);

        session.setAttribute("user",userSession);
            resp.sendRedirect("/profile");

    }
}
