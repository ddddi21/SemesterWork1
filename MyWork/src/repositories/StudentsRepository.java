package repositories;

import models.Homework;
import models.Student;

import java.util.List;

public interface StudentsRepository extends CrudRepository <Student> {
    List <Student> findAllMyClassmates(Integer group);
}
