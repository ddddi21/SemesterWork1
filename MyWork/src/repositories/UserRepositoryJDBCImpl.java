package repositories;

import singletones.ConnectionProvider;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJDBCImpl implements UserRepository {
    private Connection connection;

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "SELECT  * from all_user WHERE user_id=?";

    //language=SQL
    private static final String SQL_SELECT_BY_EMAIL = "SELECT  * from all_user WHERE email = ?";

    //language=SQL
    private static final String SQL_SELECT_BY_EMAIL_AND_PASSWORD = "SELECT * from all_user WHERE email = ? and password = ?";

    //language=SQL
    private static final String SQL_SELECT_ID_BY_EMAIL = "SELECT user_id from all_user WHERE email=?";

    //language=SQL
    private static final String SQL_FIND_ALL = "SELECT * from all_user";

    //language=SQL
    private static final String SQL_SAVE = "INSERT into all_user(first_name, last_name, age, role, email, password) values(?,?,?,?,?,?)";

    //language=SQL
    private static final String SQL_UPDATE =
            "UPDATE all_user SET first_name = ?, last_name = ?, age = ?, role = ?, email = ?, password = ? WHERE  user_id = ?";



    public UserRepositoryJDBCImpl()  {
        try {
            connection = ConnectionProvider.getConnection();
        } catch (ClassNotFoundException e) {
            throw  new IllegalStateException(e);
        }
    }


    @Override
    public Optional <Long> findIdByEmail(String email) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ID_BY_EMAIL)){
            preparedStatement.setString(1,email);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    Long id = resultSet.getLong("user_id");
                    return Optional.of(id);
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw  new  IllegalStateException(e);
        }
    }

    @Override
    public boolean isExist(String email, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_EMAIL_AND_PASSWORD)){
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
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
    public List findAll() {
        User user;
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL)) {
            while (resultSet.next()) {
                user = userRowMapper.mapRow(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return users;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_EMAIL);
            statement.setString(1, email);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(userRowMapper.mapRow(resultSet));
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        if(id<0) return Optional.empty();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(userRowMapper.mapRow(resultSet));
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(User entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setInt(3, entity.getAge());
            preparedStatement.setString(4, entity.getRole());
            preparedStatement.setString(5, entity.getEmail());
            preparedStatement.setString(6, entity.getPassword());

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
    public void update(User entity) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)){
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setInt(3, entity.getAge());
            preparedStatement.setString(4, entity.getRole());
            preparedStatement.setString(5, entity.getEmail());
            preparedStatement.setString(6, entity.getPassword());

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
            int updRows = statement.executeUpdate("DELETE from all_user where user_id = " + id + ";");
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
    public void delete(User entity) {
    }

    private RowMapper<User> userRowMapper = row -> {
        //Получаем id из соответствующей колонки
        Long id = row.getLong("user_id");
        //Получаем имя из соответсвующей колонки
        String firstName = row.getString("first_name");
        //Получаем фамилию из соответсвующей колонки
        String lastName = row.getString("last_name");
        String role = row.getString("role");
        //Получаем возраст из соответветсвующей колонки
        Integer age = row.getObject("age", Integer.class);
        String email = row.getString("email");
        String password = row.getString("password");
        //создаём и возвращаем объект User из полученных данных
        return new User(id,firstName,lastName,role,age,email,password);
    };

}
