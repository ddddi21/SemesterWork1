package repositories;

import models.Group;
import models.Homework;
import models.Student;
import models.Teacher;

import java.util.List;

public interface TeachersRepository extends CrudRepository <Teacher> {
    List <Group> findAllGroups();
    List <Student>findAllStudent();
    List <Homework> findAllHomeworkToGroup(Integer group);

    void addHomework(Integer group, Integer deadline);
    void editHomework(Integer id);
    void deleteHomework(Integer id);


}
