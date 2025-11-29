package com.example.myproject.myproject.service;

import com.example.myproject.myproject.model.Product;
import com.example.myproject.myproject.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return  productRepo.findById(id);
    }

    public Product addProduct(Product product) {
        return  productRepo.save(product);
    }
}