package com.example.myproject.myproject.controller;
import com.example.myproject.myproject.model.Product;
import com.example.myproject.myproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private ProductService service;
    @GetMapping("products")
    public List<Product> allProducts(){
        return service.getAllProducts();
    }
    @GetMapping("product/{id}")
    public Optional<Product> productById(@PathVariable("id") int id){
        return service.getProductById(id);
    }
    @PostMapping("product")
    public Product postProduct(@RequestBody Product product){
      Product product1= service.addProduct(product);
      return  product1;
    }

}
