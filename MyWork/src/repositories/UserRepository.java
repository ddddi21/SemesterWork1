package repositories;

import models.Homework;
import models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
    List<Homework> findAllHomeworkWithDeadlineLike(Integer deadline);
    Optional findIdByEmail(String email);
}