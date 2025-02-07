package com.eduardo.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.eduardo.springboot.di.app.springboot_di.models.Product;
import com.eduardo.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServicesImp implements ProductService{
    @Autowired
    private Environment environment;
    @Autowired
    @Qualifier("productRepositoryJson")
    private ProductRepository repository;

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            //Product newProduct = new Product(p.getId(), p.getName(), priceImp.longValue());
            //return newProduct;
            Product newProduct = (Product)p.clone();
            newProduct.setPrice(priceImp.longValue());
            return newProduct;
            //p.setPrice(priceImp.longValue());
            //return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
