package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public abstract class GenericCRUD<T>{
    protected SessionFactory sessionFactory;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    public GenericCRUD() {
        sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }

    public boolean insert(T t) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e.getMessage());
            transaction.rollback();
        }
        return false;
    }

    public boolean update(T t) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e.getMessage());
            transaction.rollback();
        }
        return false;
    }

    public Optional<T> findByID(Class<T> clazz, Object id) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        T t = session.find(clazz, id);
        transaction.commit();
        return t == null ? Optional.empty() : Optional.of(t);
    }
}
