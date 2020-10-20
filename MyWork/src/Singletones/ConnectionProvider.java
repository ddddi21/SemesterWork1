package Singletones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection connection;
    private static final String userName = "user_for_sem1";
    private static final String password = "qwerty";
    private static final String url = "jdbc:postgresql://localhost:5432/sem1_db";
    private static final String driverClassName = "org.postgresql.Driver";

    //TODO(rewrite to singletone)

    private ConnectionProvider() throws ClassNotFoundException{
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url,userName,password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static  Connection getConnection() throws ClassNotFoundException {
        if (connection == null) {
            ConnectionProvider connectionProvider = new ConnectionProvider();
        }
        return connection;
    }

}
