package com.riwi.Products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.Products.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByName(String name);
}