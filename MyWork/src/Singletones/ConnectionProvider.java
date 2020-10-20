package Singletones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private static final String userName = "user_for_sem1";
    private static final String password = "qwerty";
    private static final String url = "jdbc:postgresql://localhost:5432/sem1_db";
    private static final String driverClassName = "org.postgresql.Driver";

    //TODO(rewrite to singletone)

    private ConnectionProvider() throws ClassNotFoundException {
        Class.forName(driverClassName);
    }

    public static  Connection getConnection(){
        try {
            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

}
