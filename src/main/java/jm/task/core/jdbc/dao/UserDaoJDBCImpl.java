package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    private static Connection connection = Util.getConnection();

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users(" +
                    "ID BIGINT NOT NULL AUTO_INCREMENT, NAME VARCHAR(100), " +
                    "LASTNAME VARCHAR(100), AGE INT, PRIMARY KEY (ID) )");
            System.out.println("Таблица готова");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS users");
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement prStatement = connection.prepareStatement("INSERT INTO users (NAME, LASTNAME, AGE) VALUES(?, ?, ?)")) {
            prStatement.setString(1, name);
            prStatement.setString(2, lastName);
            prStatement.setByte(3, age);
            prStatement.executeUpdate();
            System.out.println("Пользователь удален");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement prStatement = connection.prepareStatement("DELETE FROM users WHERE ID=?")) {
            prStatement.setLong(1, id);
            prStatement.executeUpdate();
            System.out.println("Пользователь удален");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery("SELECT ID, NAME, LASTNAME, AGE FROM users")) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setLastName(resultSet.getString("LASTNAME"));
                user.setAge(resultSet.getByte("AGE"));
                userList.add(user);
            }
            System.out.println("Список пользователей готов");
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("TRUNCATE TABLE users");
            System.out.println("Таблица подчищена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

