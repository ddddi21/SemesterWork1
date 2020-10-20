package services;

import models.Teacher;
import repositories.TeachersRepositoryJDBCImpl;

public class TeacherService {
    TeachersRepositoryJDBCImpl teachersRepositoryJDBC = new TeachersRepositoryJDBCImpl();

    public TeachersRepositoryJDBCImpl getTeachersRepositoryJDBC(){
        return teachersRepositoryJDBC;
    }

    public void save(Teacher teacher){
        teachersRepositoryJDBC.save(teacher);
    }
}
