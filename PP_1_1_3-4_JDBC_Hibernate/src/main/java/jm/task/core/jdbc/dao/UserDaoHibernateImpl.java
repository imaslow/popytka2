package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Transaction transaction = null;

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = (Transaction) session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users(" +
                            "ID BIGINT NOT NULL AUTO_INCREMENT, NAME VARCHAR(100), " +
                            "LASTNAME VARCHAR(100), AGE INT, PRIMARY KEY (ID) )")
                            .executeUpdate();
            transaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (null != transaction) {
                try {
                    transaction.rollback();
                } catch (SystemException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (HeuristicRollbackException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (HeuristicMixedException e) {
            throw new RuntimeException(e);
        } catch (RollbackException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = (Transaction) session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users")
                    .executeUpdate();
            transaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (null != transaction) {
                try {
                    transaction.rollback();
                } catch (SystemException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (HeuristicRollbackException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (HeuristicMixedException e) {
            throw new RuntimeException(e);
        } catch (RollbackException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = (Transaction) session.beginTransaction();
            session.persist(new User(name, lastName, (byte) age));
            transaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (null != transaction) {
                try {
                    transaction.rollback();
                } catch (SystemException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (HeuristicRollbackException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (HeuristicMixedException e) {
            throw new RuntimeException(e);
        } catch (RollbackException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = (Transaction) session.beginTransaction();
            User user = (User) session.get(User.class, id);
            if (null != user) {
                session.delete(user);
            }
            transaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (null != transaction) {
                try {
                    transaction.rollback();
                } catch (SystemException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (HeuristicRollbackException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (HeuristicMixedException e) {
            throw new RuntimeException(e);
        } catch (RollbackException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getSessionFactory().openSession()) {
            return session.createQuery("from User").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = (Transaction) session.beginTransaction();
            session.createSQLQuery("TRUNCATE TABLE user")
                    .executeUpdate();
            transaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (null != transaction) {
                try {
                    transaction.rollback();
                } catch (SystemException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (HeuristicRollbackException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (HeuristicMixedException e) {
            throw new RuntimeException(e);
        } catch (RollbackException e) {
            throw new RuntimeException(e);
        }
    }
}
