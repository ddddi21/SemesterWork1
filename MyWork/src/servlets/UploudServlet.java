package servlets;

import models.User;
import services.Helper;
import services.PhotoService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Optional;


@WebServlet("/photo")
@MultipartConfig
public class UploudServlet extends HttpServlet {
    private PhotoService fileSaver;
    private UserService userService;
    private Helper helper;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/profile");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User userSession = (User)session.getAttribute("user");
        Part photoPart = req.getPart("photo");
        Optional<String> resultOfFileSaving = fileSaver.savePhoto(photoPart, userSession.getId()+"");
        if (resultOfFileSaving.isPresent()) {
            Optional<User> userCandidate = userService.findUserById(userSession.getId());
            if (userCandidate.isPresent()) {
                User user = userCandidate.get();
                if(user.getImagePath() != null){
                    File file = new File(getServletContext().getRealPath("") + user.getImagePath());
                    file.delete();
                }
                user.setImagePath(resultOfFileSaving.get());
                userService.update(user);
                session.setAttribute("user",user);
                resp.sendRedirect("/profile");
            } else {
                throw new IllegalArgumentException("Пользователь не существует");
            }
        } else {
            throw new IllegalArgumentException("Передан пустой файл");
        }
    }

    @Override
    public void init() throws ServletException {
        fileSaver = new PhotoService(getServletContext().getRealPath(""));
        userService = new UserService();
        helper = new Helper();
    }
}
