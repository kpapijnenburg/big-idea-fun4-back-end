package fitnessapp.service;

import fitnessapp.config.HibernateUtil;
import fitnessapp.interfaces.IService;
import fitnessapp.model.Exercise;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class ExerciseService implements IService<Exercise> {

    private HibernateUtil util;

    public ExerciseService() {
        this.util = new HibernateUtil();
    }


    @Override
    public Exercise getById(long id) {
        try(Session session = util.getSessionFactory().openSession()){
            return session.get(Exercise.class, id);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Exercise> getAll() {
        try(Session session = util.getSessionFactory().openSession()){
            return session.createQuery("FROM Exercise", Exercise.class).list();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Exercise exercise) {
        Transaction tx = null;

        try(Session session = util.getSessionFactory().openSession()){
            tx = session.beginTransaction();

            session.save(exercise);

            tx.commit();

            return true;
        } catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        }
        return false;
    }

    @Override
    public boolean update(Exercise exercise) {
        Transaction tx = null;

        try(Session session = util.getSessionFactory().openSession()){
            tx = session.beginTransaction();

            session.update(exercise);

            tx.commit();
            return true;
        } catch (Exception e){
            if (tx != null){
                tx.rollback();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Exercise exercise) {
        Transaction tx = null;

        try(Session session = util.getSessionFactory().openSession()){
            tx = session.beginTransaction();

            session.delete(exercise);

            tx.commit();
            return true;
        } catch (Exception e){
            if (tx != null){
                tx.rollback();
            }
        }
        return false;
    }
}
