package com.eduardo.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.springboot.di.app.springboot_di.models.Product;
import com.eduardo.springboot.di.app.springboot_di.services.ProductServices;

@RestController
@RequestMapping("/api")
public class SomeController {
    private ProductServices service = new ProductServices();

    @GetMapping
    public List<Product> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return service.findById(id);
    }
}
