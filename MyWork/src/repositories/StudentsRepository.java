package repositories;

import models.Homework;
import models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentsRepository extends CrudRepository <Student> {
    List <Student> findAllMyClassmates(Integer group);
    Optional findByUserId(Long id);
}
