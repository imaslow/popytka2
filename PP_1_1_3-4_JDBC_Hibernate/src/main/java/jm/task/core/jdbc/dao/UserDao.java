package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.util.List;

public interface UserDao {
    void createUsersTable() throws HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException;

    void dropUsersTable() throws HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException;

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
