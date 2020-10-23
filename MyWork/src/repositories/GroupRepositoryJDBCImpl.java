package repositories;

import models.Group;
import models.Student;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class GroupRepositoryJDBCImpl implements GroupRepository {
    private Connection connection;

    private RowMapper<Group> userRowMapper = row -> {
        Integer group = row.getInt("group_number");
        Integer student_count = row.getInt("student_count");
        Integer hw_subject_id = row.getInt("hw_subject");
        //создаём и возвращаем объект User из полученных данных
        return new Group(student_count, group, hw_subject_id);
    };

    //language=SQL
    private static final String SQL_SELECT_BY_GROUP = "SELECT  * from all_groups WHERE group_number=?";

    //language=SQL
    private static final String SQL_SELECT_BY_HW_ID = "SELECT  * from all_groups WHERE hw_subjects = ?";

    //language=SQL
    private static final String SQL_FIND_ALL = "SELECT * from all_groups";

    //language=SQL
    private static final String SQL_SAVE = "INSERT into all_groups(first_name, last_name, age, role, email, password) values(?,?,?,?,?,?)";
    //TODO(make later)

    //language=SQL
    private static final String SQL_UPDATE =
            "UPDATE all_user SET first_name = ?, last_name = ?, age = ?, role = ?, email = ?, password = ? WHERE  user_id = ?";


    @Override
    public List<Group> findAll() {
        return null;
    }

    @Override
    public Optional<Group> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Group entity) {

    }

    @Override
    public void update(Group entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Group entity) {

    }

    @Override
    public List<Student> findAllStudents(Integer group) {
        return null;
    }
}
