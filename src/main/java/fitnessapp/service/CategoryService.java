package fitnessapp.service;

import fitnessapp.config.HibernateUtil;
import fitnessapp.interfaces.IService;
import fitnessapp.model.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryService implements IService<Category> {

    private HibernateUtil util;

    public CategoryService() {
        this.util = new HibernateUtil();
    }

    @Override
    public Category getById(long id) {
        try(Session session = util.getSessionFactory().openSession()){
            return session.get(Category.class, id);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Category> getAll() {
        try(Session session = util.getSessionFactory().openSession()){
            return session.createQuery("FROM Category", Category.class).list();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean save(Category category) {
        Transaction tx = null;

        try(Session session = util.getSessionFactory().openSession()){
            tx = session.beginTransaction();

            session.save(category);

            tx.commit();

            return true;
        } catch (Exception e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        Transaction tx = null;

        try(Session session = util.getSessionFactory().openSession()){
            tx = session.beginTransaction();

            session.update(category);

            tx.commit();
            return true;
        } catch (Exception e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Category category) {
        Transaction tx = null;

        try(Session session = util.getSessionFactory().openSession()){
            tx = session.beginTransaction();

            session.delete(category);

            tx.commit();
            return true;
        } catch (Exception e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

}
