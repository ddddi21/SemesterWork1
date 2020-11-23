package servlets;

import repositories.UserRepositoryJDBCImpl;
import services.Helper;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import models.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/editUser")
public class EditProfileServlet extends HttpServlet {
    UserRepositoryJDBCImpl userRepositoryJDBC;
    Helper helper;
    UserService userService;

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        userService = new UserService();
        userRepositoryJDBC = new UserRepositoryJDBCImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if(user != null) {
            Map<String, Object> root = new HashMap<>();
            root.put("isLogged",true);
            helper.render(req,resp,"aboutuser.ftl",root);
        }
        else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String firstName = req.getParameter("name");
        String secondName = req.getParameter("lastName");
        if(!firstName.isEmpty()){
            user.setFirstName(firstName);
        }
        if(!secondName.isEmpty()){
            user.setLastName(secondName);
        }

        userRepositoryJDBC.update(user);
        session.setAttribute("user",user);
        resp.sendRedirect("/profile");
    }
}
