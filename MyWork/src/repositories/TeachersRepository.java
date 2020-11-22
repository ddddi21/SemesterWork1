package repositories;


import models.Homework;
import models.Student;
import models.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeachersRepository extends CrudRepository <Teacher> {
    List<Integer> findAllGroups();
    List <Student>findAllStudent();
    List <Homework> findAllHomeworkToGroup(Integer group);
    Optional findByUserId(Long id);

    //TODO(а нужно ли)
    void addHomework(Integer group, Integer deadline);
    void editHomework(Integer id);
    void deleteHomework(Integer id);


}
