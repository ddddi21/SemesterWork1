package servlets;

import models.Homework;
import models.Student;
import models.Teacher;
import models.User;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@WebServlet("/getHw")
public class GetHwServlet extends HttpServlet {
    private  HomeworkService homeworkService;
    private UserService userService;
    private Helper helper;
    private TeacherService teacherService;
    private StudentService studentService;
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
        User user = (User)session.getAttribute("user");
        Integer group=0;
        if(user.getRole().equals("teacher")) {
            Optional <Teacher> teacher = teacherService.findByUserOd(user.getId());
            if(teacher.isPresent()){
                group = teacher.get().getGroups();
            }else {
                throw new IllegalStateException();
            }
        } else if(user.getRole().equals("student")) {
            Optional <Student> student = studentService.findByUserOd(user.getId());
            if(student.isPresent()){
                group = student.get().getGroup();
            }else {
                throw new IllegalStateException();
            }
        }

        List<Homework> homeworkList = homeworkService.findHwByGroup(group);
        StringBuilder allHw = new StringBuilder();
        for (Homework homework : homeworkList) {
            allHw.append(homework.getSubject()).append("#").append(homework.getHw_text()).append("#").append(homework.getDeadline()).append("!");
        }
        resp.getWriter().println(allHw);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
         homeworkService = new HomeworkService();
        userService = new UserService();
        helper = new Helper();
        teacherService = new TeacherService();
        studentService = new StudentService();
    }
}
