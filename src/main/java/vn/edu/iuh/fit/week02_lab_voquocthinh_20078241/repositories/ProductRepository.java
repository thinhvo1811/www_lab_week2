package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.ProductStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Product;

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
}
