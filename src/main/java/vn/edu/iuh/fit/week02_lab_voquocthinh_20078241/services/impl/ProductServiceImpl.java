package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl;

import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Product;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories.ProductRepository;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl() {
        productRepository = new ProductRepository();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public List<Product> getProductsByKeyword(String keyword) {
        return productRepository.getProductsByKeyword(keyword);
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        return productRepository.getProductsByManufacturer(manufacturer);
    }

    @Override
    public List<String> getAllManufacturers() {
        return productRepository.getAllManufacturers();
    }

    @Override
    public Optional<Product> findByID(long id) {
        return productRepository.findByID(Product.class, id);
    }
}
