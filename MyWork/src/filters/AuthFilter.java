package filters;

import models.User;
import services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

//TODO(add when i make a new servlets)
@WebFilter(urlPatterns = {"/registration","/studentRegistration", "/teacherRegistration", "/home", "/editUser", "/getHw", "/homework","/hwCreate","/login","/logout","/profile","/ajax_search","/photo","/user"}, filterName = "AuthFilter")
public class AuthFilter implements Filter {
    private UserService userService = new UserService();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                request.setAttribute("user", user);
            } else{
                session = request.getSession(true);
                this.checkCookies(request.getCookies(),session,request,response);
            }
        } else{
            session = request.getSession(true);
            this.checkCookies(request.getCookies(),session,request,response);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private void checkCookies(Cookie[] cookies, HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cookieForAuth")) {
                    Optional<User> user = userService.findUserByEmail(cookie.getValue());
                    if (user.isPresent()) {
                        if (session.getAttribute("user") == null) {
                            session.setAttribute("user",user.get());
                        }
                    }
                    break;
                }
            }
        }
    }
}
