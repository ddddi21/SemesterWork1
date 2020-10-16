package servlets;

import repositories.TeachersRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/teachers")
public class TeachersServlet extends HttpServlet {
    private TeachersRepository teachersRepository;
}
