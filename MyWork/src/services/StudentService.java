package services;

import models.Student;
import repositories.StudentsRepositoryJDBCImpl;

public class StudentService {
    StudentsRepositoryJDBCImpl studentsRepositoryJDBC = new StudentsRepositoryJDBCImpl();

    public StudentsRepositoryJDBCImpl getStudentsRepositoryJDBC(){
        return studentsRepositoryJDBC;
    }

    public void save(Student student){
        studentsRepositoryJDBC.save(student);
    }
}
