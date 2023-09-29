package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl;

import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Product;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories.ProductRepository;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl() {
        productRepository = new ProductRepository();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
