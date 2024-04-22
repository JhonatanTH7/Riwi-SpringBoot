package com.riwi.Products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.Products.entities.Product;
import com.riwi.Products.repositories.ProductRepository;
import com.riwi.Products.services.serviceAbstract.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository objProductRepository;

    @Override
    public Product save(Product product) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Product> getAll() {
        return this.objProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Product update(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Product> search(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

}
