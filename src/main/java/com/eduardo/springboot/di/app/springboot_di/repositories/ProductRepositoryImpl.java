package com.eduardo.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eduardo.springboot.di.app.springboot_di.models.Product;

@Component
public class ProductRepositoryImpl implements ProductRepository{
    private List<Product> data; 

    public ProductRepositoryImpl(){
        this.data =  Arrays.asList(
            new Product(1L, "Memoria", 300L),
            new Product(2L, "Monitor", 250L),
            new Product(3L, "Radeon 6600", 430L),
            new Product(4L, "B550M", 120L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data; 
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
