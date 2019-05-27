package fitnessapp.service;

import fitnessapp.config.HibernateUtil;
import fitnessapp.interfaces.IService;
import fitnessapp.model.WorkOut;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class WorkOutService implements IService<WorkOut> {

    private HibernateUtil util;

    public WorkOutService() {
        util = new HibernateUtil();
    }

    @Override
    public WorkOut getById(long id) {
        try (Session session = util.getSessionFactory().openSession()) {
            return session.get(WorkOut.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<WorkOut> getAll() {
        try (Session session = util.getSessionFactory().openSession()) {
            return session.createQuery("FROM WorkOut", WorkOut.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(WorkOut workOut) {
        Transaction tx = null;

        try (Session session = util.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.save(workOut);

            tx.commit();

            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }
        return false;
    }

    @Override
    public boolean update(WorkOut workOut) {
        Transaction tx = null;

        try (Session session = util.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.merge(workOut);

            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        }
        return false;
    }

    @Override
    public boolean delete(WorkOut workOut) {
        Transaction tx = null;

        try(Session session = util.getSessionFactory().openSession()){
            tx = session.beginTransaction();

            session.delete(workOut);

            tx.commit();
            return true;
        } catch (HibernateException e){
            if (tx != null) tx.rollback();
        }
        return false;

    }

    public List getByUserId(long id) {
        try(Session session = util.getSessionFactory().openSession()){

            String hql = "FROM WorkOut WHERE userId = :userId";
            Query query = session.createQuery(hql);
            query.setParameter("userId", id);

            return query.list();
        } catch (HibernateException e){
            e.printStackTrace();
            return null;
        }
    }
}
