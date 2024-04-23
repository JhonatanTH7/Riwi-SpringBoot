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
    public Product findById(Long id) {
        return this.objProductRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAll() {
        return this.objProductRepository.findAll();
    }

    @Override
    public Product save(Product objProduct) {
        return this.objProductRepository.save(objProduct);
    }

    @Override
    public Product update(Long id, Product objProduct) {
        this.objProductRepository.findById(id).orElseThrow();
        objProduct.setId(id);
        return this.objProductRepository.save(objProduct);
    }

    @Override
    public void delete(Long id) {
        Product productFind = this.objProductRepository.findById(id).orElseThrow();
        this.objProductRepository.delete(productFind);
    }

    @Override
    public List<Product> search(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

}
