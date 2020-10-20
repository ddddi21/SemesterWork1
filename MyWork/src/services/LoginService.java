package services;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    static List<User> userList = new ArrayList<>();


    public boolean login(String email, String password){
        User userCandidate = new User(email, password);
        for(User user: userList){
            if(user.getEmail().equals(userCandidate.getEmail()) && (user.getPassword().equals(userCandidate.getPassword()))) return true;
        }
        return false;
    }
    //TODO(rewrite to jdcb)
}