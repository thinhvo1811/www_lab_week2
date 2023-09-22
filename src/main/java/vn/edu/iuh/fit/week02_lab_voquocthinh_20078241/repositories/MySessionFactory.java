package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.ProductStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.*;

public class MySessionFactory {
    private static MySessionFactory instance;
    private SessionFactory sessionFactory;

    private MySessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(ProductImage.class)
                .addAnnotatedClass(ProductPrice.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class)
                .getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public static MySessionFactory getInstance() {
        if(instance == null)
            instance = new MySessionFactory();
        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
