package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
    public static final String NAME_USER = "root";
    public static final String PASSWORD = "root1234";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось загрузить");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, NAME_USER, PASSWORD);
            System.out.println("Connection OK!");
        } catch (SQLException e) {
            System.out.println("Connection ERROR!");
            e.printStackTrace();
        }
        return connection;
    }

}

