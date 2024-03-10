package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";

    private static Connection connection;
    public static Connection getConnection () throws SQLException {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return connection;
    }
}
