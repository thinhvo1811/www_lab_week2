package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository extends GenericCRUD<Order>{
    public List<Order> getAll(){
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Order> list = session.createQuery("from Order", Order.class).getResultList();
        transaction.commit();
        return list;
    }

    public List<Order> getOrdersByDate(Date date) {
        Transaction tr = null;
        try (Session session = sessionFactory.openSession()){
            tr = session.beginTransaction();
            String sql = "SELECT * from orders WHERE order_date LIKE '"+date+"%'";
            List<Object[]> list = session.createNativeQuery(sql, Object[].class).getResultList();
            List<Order> orders = new ArrayList<>();
            for (Object[] o: list) {
                orders.add(findByID(Order.class,o[0]).get());
            }
            tr.commit();
            return orders;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public List<Order> getOrdersByPeriod(Date from, Date to) {
        Transaction tr = null;
        try (Session session = sessionFactory.openSession()){
            tr = session.beginTransaction();
            String sql = "SELECT * from orders WHERE order_date BETWEEN '"+from+"' AND '"+to+"'";
            List<Object[]> list = session.createNativeQuery(sql, Object[].class).getResultList();
            List<Order> orders = new ArrayList<>();
            for (Object[] o: list) {
                orders.add(findByID(Order.class,o[0]).get());
            }
            tr.commit();
            return orders;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e.getMessage());
            tr.rollback();
        }
        return null;
    }
}
