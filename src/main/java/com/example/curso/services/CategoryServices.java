package com.example.curso.services;

import com.example.curso.entities.Category;
import com.example.curso.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category finById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

}
