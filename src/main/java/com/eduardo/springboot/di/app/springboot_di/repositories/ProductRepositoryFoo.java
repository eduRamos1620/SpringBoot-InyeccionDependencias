package com.eduardo.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.eduardo.springboot.di.app.springboot_di.models.Product;

@Repository
public class ProductRepositoryFoo implements ProductRepository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Mouse", 120L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Mouse", 120L);
    }
    
}
