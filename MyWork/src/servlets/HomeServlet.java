package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HelloServlet {

//    @Override
//    public void init() throws ServletException {
//        super.init();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/templates/home.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
