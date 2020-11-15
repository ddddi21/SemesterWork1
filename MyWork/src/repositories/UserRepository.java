package repositories;

import models.Homework;
import models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
    Optional findIdByEmail(String email);
    Optional findByEmail(String email);
    boolean isExist(String email,String password);
    List <User> getAllUsersLikeString(String line);
}
