package services;

import models.Teacher;
import repositories.TeachersRepositoryJDBCImpl;

import java.util.Optional;

public class TeacherService {
    TeachersRepositoryJDBCImpl teachersRepositoryJDBC = new TeachersRepositoryJDBCImpl();

    public TeachersRepositoryJDBCImpl getTeachersRepositoryJDBC(){
        return teachersRepositoryJDBC;
    }

    public void save(Teacher teacher){
        teachersRepositoryJDBC.save(teacher);
    }
    public Optional<Teacher> findByUserOd(Long id){
        return teachersRepositoryJDBC.findByUserId(id);
    }
}
