package servlets;

import services.Helper;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private Helper helper;
    private LoginService loginService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        helper.render(req, resp, "login.ftl",new HashMap<>());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        File file = new File("src/users.txt");
        FileWriter writer = new FileWriter(file, true);
        String name = req.getParameter("first_name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        boolean result = loginService.login(email, password);
        resp.setContentType("text/html");
        Map<String, Object> root = new HashMap<>();
        if(result){
            root.put("name", name);
            root.put("email", email);
            helper.render(req, resp, "profile.ftl", root);

        }else{
            root.put("message","incorrect password or email");
            helper.render(req, resp, "login.ftl", root);
        }
    }

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        loginService = new LoginService();
        //TODO(filter and cookies)
    }
}