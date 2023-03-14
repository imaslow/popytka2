package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

//import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        //String sql = "CREATE TABLE IF NOT EXISTS users(" +
             //  "ID BIGINT NOT NULL AUTO_INCREMENT, NAME VARCHAR(100), " +
                //"LASTNAME VARCHAR(100), AGE INT, PRIMARY KEY (ID) )";

        //try (Connection connection = getConnection();
           //  Statement statement = connection.createStatement()) {

           // statement.executeUpdate(sql);
        //    System.out.println("Таблица готова");

       // } catch (SQLException e) {
       //     e.printStackTrace();
        //}
    }

    public void dropUsersTable() {
        //String sql = "DROP TABLE IF EXISTS users";

        //try (Connection connection = getConnection();
          //   Statement statement = connection.createStatement()) {

            //statement.executeUpdate(sql);
            //System.out.println("Таблица удалена");

        //} catch (SQLException e) {
          //  e.printStackTrace();
        //}
    }

    public void saveUser(String name, String lastName, byte age) {
        //String sql = "INSERT INTO users (NAME, LASTNAME, AGE) VALUES(?, ?, ?)";

        //try (Connection connection = getConnection();
           //  PreparedStatement prStatement = connection.prepareStatement(sql)) {

            //prStatement.setString(1, name);
           // prStatement.setString(2, lastName);
           // prStatement.setByte(3, age);

           // prStatement.executeUpdate();
           // System.out.println("Пользователь удален");

        //} catch (SQLException e) {
         //   e.printStackTrace();
        //}
    }

    public void removeUserById(long id) {
        //String sql = "DELETE FROM users WHERE ID=?";

       // try (Connection connection = getConnection();
        //     PreparedStatement prStatement = connection.prepareStatement(sql)) {

          //  prStatement.setLong(1, id);

           // prStatement.executeUpdate();
          //  System.out.println("Пользователь удален");

        //} catch (SQLException e) {
        //    e.printStackTrace();
        //}
    }

    public List<User> getAllUsers() {
        //List<User> userList = new ArrayList<>();

        //String sql = "SELECT ID, NAME, LASTNAME, AGE FROM users";

        //try (Connection connection = getConnection();
         //    Statement stat = connection.createStatement()) {

           // ResultSet resultSet = stat.executeQuery(sql);
           // while (resultSet.next()) {
              //  User user = new User();
               // user.setId(resultSet.getLong("ID"));
               // user.setName(resultSet.getString("NAME"));
                //user.setLastName(resultSet.getString("LASTNAME"));
                //user.setAge(resultSet.getByte("AGE"));

                //userList.add(user);
            //}
            //System.out.println("Список пользователей готов");
        //} catch (SQLException e) {
          //  e.printStackTrace();
        //}
        //return userList;
        return null;
    }

    public void cleanUsersTable() {
        //String sql = "TRUNCATE TABLE users";
        //try (Connection connection = getConnection();
          //   Statement statement = connection.createStatement()) {

            //statement.executeUpdate(sql);
            //System.out.println("Таблица подчищена");

        //} catch (SQLException e) {
          //  e.printStackTrace();
        //}
    }
}
