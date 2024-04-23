package com.riwi.Products.services.serviceAbstract;

import java.util.List;

import com.riwi.Products.entities.Product;

public interface IProductService {
    public Product save(Product objProduct);

    public List<Product> getAll();

    public Product findById(Long id);

    public void delete(Long id);

    public Product update(Long id, Product objProduct);

    public List<Product> search(String name);
}
