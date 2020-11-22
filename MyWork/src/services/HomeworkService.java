package services;

import models.Homework;
import repositories.HomeworkRepositoryJDBCImpl;

import java.util.List;

public class HomeworkService {
    HomeworkRepositoryJDBCImpl homeworkRepositoryJDBC = new HomeworkRepositoryJDBCImpl();
    public List<Homework> findHwByGroup(Integer group){
        return homeworkRepositoryJDBC.findHwByGroup(group);
    }
}
