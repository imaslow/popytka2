package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соединения с БД
    private static final String NAME_USER = "root";
    private static final String PASSWORD = "root1234";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(URL, NAME_USER, PASSWORD);
            System.out.println("Подключение OK!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}

