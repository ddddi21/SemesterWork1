package servlets;

import models.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ajax_search")
public class SearchServlet extends HttpServlet {
    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        String search = req.getParameter("search");
        List<User> userList = userService.getAllUsersLikeString(search);
        StringBuilder stringBuilder = new StringBuilder();
        for(User user:userList){
            stringBuilder.append(user.getFirstName()).append("#").append(user.getLastName()).append("#").append(user.getRole()).append("#").append(user.getId()).append('!');
        }
        writer.println(stringBuilder);
    }
}
