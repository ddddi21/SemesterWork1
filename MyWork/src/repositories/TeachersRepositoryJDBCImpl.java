package repositories;

import Singletones.ConnectionProvider;
import models.Group;
import models.Homework;
import models.Student;
import models.Teacher;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class TeachersRepositoryJDBCImpl implements TeachersRepository {
    private Connection connection;

    //language=SQL
    private static final String SQL_INSERT_BY_USER_ID = "INSERT into teacher(user_id, subjects_id) WHERE values (?,?)";

    //TODO(do this later)

    public TeachersRepositoryJDBCImpl(Connection connection) {
        try {
            this.connection = ConnectionProvider.getConnection();
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Group> findAllGroups() {
        return null;
    }

    @Override
    public List<Student> findAllStudent() {
        return null;
    }

    @Override
    public List<Homework> findAllHomeworkToGroup(Integer group) {
        return null;
    }

    @Override
    public void addHomework(Integer group, Integer deadline) {

    }

    @Override
    public void editHomework(Integer id) {

    }

    @Override
    public void deleteHomework(Integer id) {

    }

    @Override
    public void addTeacherByUserId(Long id) {

    }



    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Teacher entity) {

    }

    @Override
    public void update(Teacher entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Teacher entity) {

    }



}
