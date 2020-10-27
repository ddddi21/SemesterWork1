package repositories;

import models.Homework;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface HomeworkRepository extends CrudRepository <Homework>{
    void hwDone(Long hw_id, Boolean isMake);
    List<Homework> findHwBySubject(String subject);
    List<Homework>  findHwByDeadline(Date deadline);
    List<Homework>  findHwByStudent(Long student_id);
    List<Homework>  findHwByGroup(Integer group);
    Boolean isHwMake(Long hw_id);


}
