package repositories;

import singletones.ConnectionProvider;
import models.Homework;
import models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentsRepositoryJDBCImpl implements StudentsRepository {
    private Connection connection;

    public StudentsRepositoryJDBCImpl(){
        try {
            this.connection = ConnectionProvider.getConnection();
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }



    //language=SQL
    private static final String SQL_SELECT_BY_ID = "SELECT  * from student WHERE student_id=?";


    //language=SQL
    private static final String SQL_FIND_ALL = "SELECT * from student";

    //language=SQL
    private static final String SQL_SAVE = "INSERT into student( user_id, group_number) values (?,?)";

    //language=SQL
    private static final String SQL_UPDATE =
            "UPDATE student SET user_id = ?, group_number = ? WHERE  student_id = ?";



    @Override
    public List<Student> findAllMyClassmates(Integer group) {
        return null;
    }


    @Override
    public List<Student> findAll() {
        Student student;
        List<Student> users = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL)) {
            while (resultSet.next()) {
                student = studentRowMapper.mapRow(resultSet);
                users.add(student);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return users;
    }

    @Override
    public Optional<Student> findById(Long id) {
        if(id<0) return Optional.empty();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(studentRowMapper.mapRow(resultSet));
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(Student entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1,entity.getUser_id());
            preparedStatement.setLong(2,entity.getGroup());

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
    public void update(Student entity) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)){
            preparedStatement.setLong(1,entity.getUser_id());
            preparedStatement.setLong(2,entity.getGroup());

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
            int updRows = statement.executeUpdate("DELETE from student where student_id = " + id + ";");
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
    public void delete(Student entity) {

    }

    private RowMapper<Student> studentRowMapper = row -> {
        //Получаем id из соответствующей колонки
        Long student_id = row.getLong("student_id");
        Long user_id = row.getLong("user_id");
        Integer group_number = row.getInt("group_number");
        //создаём и возвращаем объект User из полученных данных
        return new Student(student_id,user_id,group_number);
    };
}
