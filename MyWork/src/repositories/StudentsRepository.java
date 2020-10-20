package repositories;

import models.Homework;
import models.Student;

import java.util.List;

public interface StudentsRepository extends CrudRepository <Student> {
    List <Homework> findAllHomeworkBySubject(String subject);
    List <Student> findAllMyClassmates(Integer group);

    void addStudentByUserId(Long id);

    void makeHomework(Integer id);
    boolean isMakeHomework(Integer id);
}
