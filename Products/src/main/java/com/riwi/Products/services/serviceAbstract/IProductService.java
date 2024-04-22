package com.riwi.Products.services.serviceAbstract;

import java.util.List;

import com.riwi.Products.entities.Product;

public interface IProductService {
    public Product save(Product product);

    public List<Product> getAll();

    public Product findById(Long id);

    public boolean delete(Long id);

    public Product update(Long id);

    public List<Product> search(String name);
}
