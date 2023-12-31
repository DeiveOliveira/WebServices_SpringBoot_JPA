package com.example.curso.resources;

import com.example.curso.entities.Product;
import com.example.curso.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductServices services;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = services.findAll();
         return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findByid(@PathVariable Long id){
        Product obj = services.finById(id);
        return ResponseEntity.ok().body(obj);
    }
}
