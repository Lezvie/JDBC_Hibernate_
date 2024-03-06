package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl User = new UserServiceImpl();
        User.dropUsersTable();

    }
}
