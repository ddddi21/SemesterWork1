package servlets;

import services.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/home")
public class HomeServlet extends HelloServlet {
    private Helper helper;

    @Override
    public void init() throws ServletException {
        helper = new Helper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        helper.render(req, resp, "home.ftl",new HashMap<>());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String enter = req.getParameter("enter");
        if(enter.equals("sign_in")){
            resp.sendRedirect("/login");
        }else {
            if (enter.equals("registration")){
                resp.sendRedirect("/registration");
            }
        }
    }
}
