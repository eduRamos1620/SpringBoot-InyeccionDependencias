package com.eduardo.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.eduardo.springboot.di.app.springboot_di.models.Product;
import com.eduardo.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductServices {
    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            Product newProduct = new Product(p.getId(), p.getName(), priceImp.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }
}
