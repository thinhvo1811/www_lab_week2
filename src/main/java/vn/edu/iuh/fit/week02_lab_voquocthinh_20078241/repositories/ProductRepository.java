package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.ProductStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends GenericCRUD<Product>{
    public List<Product> getAll() {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Product> products = session.createNamedQuery("Product.findAll", Product.class)
                .setParameter(1, ProductStatus.ACTIVE)
                .getResultList();
        transaction.commit();
        return products;
    }

    public List<Product> getProductsByKeyword(String keyword) {
        Transaction tr = null;
        try (Session session = sessionFactory.openSession()){
            tr = session.beginTransaction();
            String sql = "SELECT * from products WHERE NAME LIKE '%"+keyword+"%'";
            List<Object[]> list = session.createNativeQuery(sql, Object[].class).getResultList();
            List<Product> products = new ArrayList<>();
            for (Object[] o: list) {
                products.add(findByID(Product.class,o[0]).get());
            }
            tr.commit();
            return products;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e.getMessage());
            tr.rollback();
        }
        return null;
    }
}
