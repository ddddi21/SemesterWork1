package services;

import models.Student;
import repositories.StudentsRepositoryJDBCImpl;

import java.util.Optional;

public class StudentService {
    StudentsRepositoryJDBCImpl studentsRepositoryJDBC = new StudentsRepositoryJDBCImpl();

    public StudentsRepositoryJDBCImpl getStudentsRepositoryJDBC(){
        return studentsRepositoryJDBC;
    }

    public void save(Student student){
        studentsRepositoryJDBC.save(student);
    }
    public Optional<Student> findByUserOd(Long id){
        return studentsRepositoryJDBC.findByUserId(id);
    }
}
