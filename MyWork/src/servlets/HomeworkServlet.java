package servlets;

import models.User;
import services.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/homework")
public class HomeworkServlet extends HttpServlet {
    Helper helper = new Helper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User userSession = (User)session.getAttribute("user");

        if(session.getAttribute("user") != null){
            Map<String, Object> root = new HashMap<>();
            root.put("isLogged",true);
            root.put("role",userSession.getRole());
            helper.render(req,resp,"homework.ftl",root);
        }else{
            Map<String, Object> root = new HashMap<>();
            root.put("isLogged",false);
            helper.render(req,resp,"home.ftl",root);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
    }
}