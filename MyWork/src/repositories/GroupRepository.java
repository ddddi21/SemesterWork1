package repositories;

import models.Group;
import models.Student;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group> {
    List<Student> findAllStudents(Integer group);
}
