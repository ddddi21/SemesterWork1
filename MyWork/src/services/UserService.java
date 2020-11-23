package services;

import models.User;
import org.mindrot.jbcrypt.BCrypt;
import repositories.UserRepositoryJDBCImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;

public class UserService {
    UserRepositoryJDBCImpl userRepositoryJDBC = new UserRepositoryJDBCImpl();

    public UserRepositoryJDBCImpl getUserRepositoryJDBC() {
        return userRepositoryJDBC;
    }


    public Optional<User> findUserByEmail(String email){
        return userRepositoryJDBC.findByEmail(email);
    }

    public boolean isUserExist(User user){
        return userRepositoryJDBC.isExist(user.getEmail(),user.getPassword());
    }

    public boolean isAlreadyHaveAccount(String email){
        if(userRepositoryJDBC.findByEmail(email).isPresent()){
            return true;
        }else{
            return false;
        }
    }

    public boolean isUserAdd(User user){
        userRepositoryJDBC.save(user);
        return true;
    }
    public Optional<String> readCookie(String key, HttpServletRequest req, HttpServletResponse resp) {
        return Arrays.stream(req.getCookies())
                .filter(c -> key.equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
    }

    public Optional<User> findUserById(Long id){
        return userRepositoryJDBC.findById(id);
    }

    public Optional<Long> findIdByEmail(String email){
        return userRepositoryJDBC.findIdByEmail(email);
    }
    public void save(User user){
        userRepositoryJDBC.save(user);
    }

    public void update(User user){
        userRepositoryJDBC.update(user);
    }

    public List<User>getAllUsersLikeString(String s){
        return userRepositoryJDBC.getAllUsersLikeString(s);
    }

    public boolean login(String username,String password){
        Optional<User> checkUser = userRepositoryJDBC.findByEmail(username);
        if(checkUser.isPresent()){
            User checked = checkUser.get();
            return BCrypt.  checkpw(password,checked.getPassword());
        }
        else return false;
    }

}
