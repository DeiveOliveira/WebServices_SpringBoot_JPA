package com.example.curso.repositories;

import com.example.curso.entities.Category;
import com.example.curso.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
