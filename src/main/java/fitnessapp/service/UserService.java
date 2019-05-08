package fitnessapp.service;

import fitnessapp.config.HibernateUtil;
import fitnessapp.interfaces.IService;
import fitnessapp.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

//todo add password hashing.
// todo sanitize user

public class UserService implements IService<User> {

    private HibernateUtil util;

    public UserService() {
        util = new HibernateUtil();
    }

    @Override
    public Optional<User> getById(long id) {
        try(Session session = util.getSessionFactory().openSession()){
            Optional<User> user = session.byId(User.class).loadOptional(1L);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<User> getAll() {
        try(Session session = util.getSessionFactory().openSession()){
            return session.createQuery("FROM User", User.class).list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(User user) {
        Transaction tx = null;

        try (Session session = util.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.save(user);

            tx.commit();

            return true;
        } catch (ConstraintViolationException e){
            return false;
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        Transaction tx = null;

        try(Session session = util.getSessionFactory().openSession()){
            tx = session.beginTransaction();

            session.update(user);

            tx.commit();
            return true;
        } catch (HibernateException e){
            if (tx != null){
                tx.rollback();
            }
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        Transaction tx = null;

        try(Session session = util.getSessionFactory().openSession()){
            tx = session.beginTransaction();

            session.delete(user);

            tx.commit();
            return true;
        } catch (HibernateException e){
            if (tx != null){
                tx.rollback();
            }
        }
        return false;
    }

    public User getByCredentials(String email, String password) {
        try(Session session = util.getSessionFactory().openSession()){

            String hql = "FROM User WHERE email = :email AND password = :password";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            query.setParameter("password", password);

            return (User) query.getSingleResult();
        } catch (HibernateException e){
            return null;
        }
    }
}
