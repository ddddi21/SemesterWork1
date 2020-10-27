package repositories;

import Singletones.ConnectionProvider;
import models.Group;
import models.Homework;
import models.Student;
import models.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeachersRepositoryJDBCImpl implements TeachersRepository {
    private Connection connection;

    //language=SQL
    private static final String SQL_INSERT_BY_USER_ID = "INSERT into teacher(user_id, subject) WHERE values (?,?)";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "SELECT  * from teacher WHERE teacher_id=?";



    //language=SQL
    private static final String SQL_FIND_ALL = "SELECT * from teacher";

    //language=SQL
    private static final String SQL_SAVE = "INSERT into teacher(user_id, subject, group) values (?,?,?)";

    //language=SQL
    private static final String SQL_UPDATE =
            "UPDATE teacher SET user_id = ?, subject = ? WHERE  teacher_id = ?";


    //TODO(do this later)

    public TeachersRepositoryJDBCImpl() {
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
    public void addTeacherByUserId(Long id,Long sub_id) {
//        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO teacher(user_id, subjects_id) values (?,?) ")){
//            preparedStatement.setLong(1,id);
//            preparedStatement.setLong(2, sub_id);
//            try(ResultSet resultSet = preparedStatement.executeQuery()){
//                if(resultSet.next()){
//
//                }
//            }
//            return Optional.empty();
//        } catch (SQLException e) {
//            throw  new  IllegalStateException(e);
//        }
    }



    @Override
    public List<Teacher> findAll() {
        Teacher teacher;
        List<Teacher> users = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL)) {
            while (resultSet.next()) {
                teacher = teacherRowMapper.mapRow(resultSet);
                users.add(teacher);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return users;
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        if(id<0) return Optional.empty();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(teacherRowMapper.mapRow(resultSet));
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(Teacher entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
           preparedStatement.setLong(1,entity.getUser_id());
           preparedStatement.setString(2,entity.getSubject());
           preparedStatement.setInt(3, entity.getGroups());

            int updRows = preparedStatement.executeUpdate();
            if (updRows == 0) {
                //Если ничего не было изменено, значит возникла ошибка
                //Возбуждаем соответсвующее исключений
                throw new SQLException();
            }
            //Достаём созданное Id пользователя
            try (ResultSet set = preparedStatement.getGeneratedKeys()) {
                //Если id  существет,обновляем его у подели.
                if (set.next()) {
                    entity.setId(set.getLong(1));
                } else {
                    //Модель сохранилась но не удаётся получить сгенерированный id
                    //Возбуждаем соответвующее исключение
                    throw new SQLException();
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public void update(Teacher entity) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)){
            preparedStatement.setLong(1,entity.getUser_id());
            preparedStatement.setString(2,entity.getSubject());

            int updRows = preparedStatement.executeUpdate();
            if (updRows == 0) {
                throw new SQLException();
            }
        } catch (SQLException e){
            throw new IllegalStateException(e);
        }

    }

    @Override
    public void deleteById(Long id) {
        //id не может быть меньше 0(в противном случае выбрасываем исключение).
        if (id < 0L) throw new IllegalArgumentException();
        /* Мы выполняем sql-запрос, удаляя строку из таблицы по параметру id. */
        //Создаём новый объект Statement
        //Использование try-with-resources необходимо для гарантированного закрытия statement,вне зависимости от успешности операции.
        try (Statement statement = connection.createStatement()) {
            //Выолняем запрос и получаем колличество изменённых строк
            int updRows = statement.executeUpdate("DELETE from teacher where teacher_id = " + id + ";");
            if (updRows == 0) {
                //Если ничего не было изменено, значит возникла ошибка
                //Возбуждаем соответсвующее исключений
                throw new SQLException();
            }
        } catch (SQLException e) {
            //Если удаление провалилось, обернём пойманное исключение в непроверяемое и пробросим дальше(best-practise)
            throw new IllegalStateException(e);
        }

    }

    @Override
    public void delete(Teacher entity) {

    }

    private RowMapper<Teacher> teacherRowMapper = row -> {
        //Получаем id из соответствующей колонки
        Long teacher_id = row.getLong("teacher_id");
        Long user_id = row.getLong("user_id");
        String subject = row.getString("subject");
        //создаём и возвращаем объект User из полученных данных
        return new Teacher(teacher_id,user_id,subject);
    };


}
