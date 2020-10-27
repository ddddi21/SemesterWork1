package repositories;

import models.Homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HomeworkRepositoryJDBCImpl implements HomeworkRepository {
    private Connection connection;

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "SELECT  * from all_hw WHERE hw_id=?";

    //language=SQL
    private static final String SQL_SELECT_BY_GROUP = "SELECT  * from all_hw WHERE group_number =?";
    //language=SQL
    private static final String SQL_SELECT_BY_DEADLINE = "SELECT  * from all_hw WHERE deadline =  ?";

    //language=SQL
    private static final String SQL_SELECT_BY_SUBJECT = "SELECT  * from all_hw WHERE subject= ?";

    //language=SQL
    private static final String SQL_SELECT_BY_STUDENT = "SELECT  * from is_hw_make WHERE student_id= ?";

    //language=SQL
    private static final String SQL_SELECT_BY_GROUP_SUBJECT_DEADLINE= "SELECT * from all_hw WHERE group_number= ? and subject = ? and deadline = ?";

    //language=SQL
    private static final String SQL_SELECT_IS_MAKE = "SELECT is_make from is_hw_make WHERE hw_id=?";

    //language=SQL
    private static final String SQL_FIND_ALL_HW = "SELECT * from all_hw";

    //language=SQL
    private static final String SQL_FIND_ALL_MAKE_HW = "SELECT * from is_hw_make";

    //language=SQL
    private static final String SQL_ADD_HW = "INSERT into all_hw(deadline, hw_text, subject, group_number) values(?,?,?,?)";

    //language=SQL
    private static final String SQL_HW_DONE = "INSERT into is_hw_make(hw_id, is_make) values (?,?)";

    //language=SQL
    private static final String SQL_UPDATE =
            "UPDATE all_hw SET deadline = ?, hw_text = ?, subject = ?, group_number = ? WHERE hw_id= ?";



    @Override
    public void hwDone(Long hw_id, Boolean isMake){
        Homework homework = findById(hw_id).get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_HW_DONE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, hw_id);
            preparedStatement.setBoolean(2, isMake);

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
                    homework.setId(set.getLong(1));
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
    public List<Homework>  findHwBySubject(String subject) {
        Homework homework;
        List<Homework> list= new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_SUBJECT)){
            preparedStatement.setString(1,subject);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    homework = homeworkRowMapper.mapRow(resultSet);
                    list.add(homework);
                }
            }
            return list;
        } catch (SQLException e) {
            throw  new  IllegalStateException(e);
        }
    }

    @Override
    public  List<Homework> findHwByDeadline(Date deadline) {
        Homework homework;
        List<Homework> list= new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_DEADLINE)){
            preparedStatement.setDate(1,deadline);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    homework = homeworkRowMapper.mapRow(resultSet);
                    list.add(homework);
                }
            }
            return list;
        } catch (SQLException e) {
            throw  new  IllegalStateException(e);
        }
    }

    @Override
    public  List<Homework> findHwByStudent(Long student_id) {
        Homework homework;
        List<Homework> list= new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_STUDENT)){
            preparedStatement.setLong(1,student_id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    homework = homeworkRowMapper.mapRow(resultSet);
                    list.add(homework);
                }
            }
            return list;
        } catch (SQLException e) {
            throw  new  IllegalStateException(e);
        }
    }

    @Override
    public  List<Homework> findHwByGroup(Integer group) {
        Homework homework;
        List<Homework> list= new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_GROUP)){
            preparedStatement.setInt(1,group);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    homework = homeworkRowMapper.mapRow(resultSet);
                    list.add(homework);
                }
            }
            return list;
        } catch (SQLException e) {
            throw  new  IllegalStateException(e);
        }
    }

    @Override
    public Boolean isHwMake(Long hw_id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_IS_MAKE)){
            preparedStatement.setLong(1,hw_id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            throw  new  IllegalStateException(e);
        }
    }

    @Override
    public List<Homework> findAll() {
        Homework homework;
        List<Homework> homeworkList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_HW)) {
            while (resultSet.next()) {
                homework = homeworkRowMapper.mapRow(resultSet);
                homeworkList.add(homework);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return homeworkList;
    }

    @Override
    public Optional<Homework> findById(Long id) {
        if(id<0) return Optional.empty();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(homeworkRowMapper.mapRow(resultSet));
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(Homework entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_HW, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, entity.getDeadline());
            preparedStatement.setString(2, entity.getHw_text());
            preparedStatement.setString(3, entity.getSubject());
            preparedStatement.setInt(4, entity.getGroup_number());

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
    public void update(Homework entity) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)){
            preparedStatement.setDate(1, entity.getDeadline());
            preparedStatement.setString(2, entity.getHw_text());
            preparedStatement.setString(3, entity.getSubject());
            preparedStatement.setInt(4, entity.getGroup_number());

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
            int updRows = statement.executeUpdate("DELETE from all_hw where hw_id = " + id + ";");
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
    public void delete(Homework entity) {

    }

    private RowMapper<Homework> homeworkRowMapper = row -> {
        //Получаем id из соответствующей колонки
        Long id = row.getLong("hw_id");
        //Получаем имя из соответсвующей колонки
        String hw_text = row.getString("hw_text");
        //Получаем фамилию из соответсвующей колонки
        String subject = row.getString("subject");
        Integer group_number = row.getInt("group_number");
        Date deadline = row.getDate("deadline");
        return new Homework(id,hw_text,subject,group_number,deadline);
    };
}
