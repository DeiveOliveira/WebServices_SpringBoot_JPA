package com.example.curso.resources;

import com.example.curso.entities.Order;
import com.example.curso.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderResource {

    @Autowired
    private OrderServices services;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = services.findAll();
         return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findByid(@PathVariable Long id){
        Order obj = services.finById(id);
        return ResponseEntity.ok().body(obj);
    }
}
