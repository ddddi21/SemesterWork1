package servlets;

import models.User;
import services.Helper;
import services.UserService;

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

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    Helper helper;
    UserService userService;

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String userId = req.getParameter("user_id");
        Optional<User> userById = userService.findUserById(Long.valueOf(userId));
        if(userById.isPresent()){
            User user = userById.get();
            Map<String, Object> root = new HashMap<>();
            root.put("pageOverlord",false);
            root.put("name", user.getFirstName());
            root.put("email", user.getEmail());
            root.put("role", user.getRole());
            root.put("age", user.getAge());
            root.put("imagepath", user.getImagePath());
            root.put("lastName", user.getLastName());
            if (user.getRole().equals("student")) {
                helper.render(req, resp, "profil.ftl", root);
            } else {
                if (user.getRole().equals("teacher")) {
                    helper.render(req, resp, "profilT.ftl", root);
                } else {
                    resp.sendRedirect("/home");
                }
            }
        }
    }
}
