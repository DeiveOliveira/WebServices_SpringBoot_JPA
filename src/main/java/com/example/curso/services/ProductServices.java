package com.example.curso.services;

import com.example.curso.entities.Product;
import com.example.curso.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product finById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

}
