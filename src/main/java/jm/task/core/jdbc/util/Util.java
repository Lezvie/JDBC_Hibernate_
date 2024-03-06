package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.driver_class", "org.postgresql.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
                    .setProperty("hibernate.connection.username", "postgres")
                    .setProperty("hibernate.connection.password", "1234")
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                    .setProperty("hibernate.show_sql", "true")
                    .setProperty("hibernate.current_session_context_class", "thread")
                    .addAnnotatedClass(User.class);
            sessionFactory = configuration.buildSessionFactory();
            sessionFactory.getCurrentSession();
        }
        return sessionFactory.openSession();
    }



    private static Connection connection;

    public static Connection getJDBCConnection() {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return connection;
    }
}
