package fitnessapp.service;

import fitnessapp.config.HibernateUtil;
import fitnessapp.interfaces.IService;
import fitnessapp.model.Set;
import fitnessapp.model.WorkOut;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class SetService implements IService<Set> {

    HibernateUtil util;

    public SetService() {util = new HibernateUtil();}

    @Override
    public Set getById(long id) {
        try (Session session = util.getSessionFactory().openSession()) {
            return session.get(Set.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Set> getAll() {
        try (Session session = util.getSessionFactory().openSession()) {
            return session.createQuery("FROM Set", Set.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Set set) {
        Transaction tx = null;

        try (Session session = util.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.save(set);

            tx.commit();

            return true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        }
        return false;
    }

    @Override
    public boolean update(Set set) {
        return false;
    }

    @Override
    public boolean delete(Set set) {
        return false;
    }

    public List<WorkOut> getByWorkOutId(long id) {
        return null;
    }
}
