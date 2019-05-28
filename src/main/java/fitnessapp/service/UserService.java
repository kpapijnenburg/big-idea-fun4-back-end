package fitnessapp.service;

import fitnessapp.config.HibernateUtil;
import fitnessapp.interfaces.IService;
import fitnessapp.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Query;
import java.util.List;

public class UserService implements IService<User> {

    private HibernateUtil util;
    private BCryptPasswordEncoder encoder;

    public UserService() {
        util = new HibernateUtil();
        encoder = new BCryptPasswordEncoder(11);
    }

    @Override
    public User  getById(long id) {
        try(Session session = util.getSessionFactory().openSession()){
            return session.get(User.class, id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        try(Session session = util.getSessionFactory().openSession()){
            List<User> users = session.createQuery("FROM User", User.class).list();

            for(User user: users){
                user.setPassword("");
            }

            return users;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(User user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

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
        try(Session session = util.getSessionFactory().openSession()) {
            String hql = "FROM User WHERE email = :email";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);

            List<User> foundUsers = query.getResultList();

            for (User user : foundUsers) {
                if (encoder.matches(password, user.getPassword())) {
                    user.setPassword("");
                    return user;
                }
            }
        } catch (HibernateException e){
            e.printStackTrace();
        }
        return null;
    }
}
