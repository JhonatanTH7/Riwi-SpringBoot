package com.riwi.Products.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Products.entities.Product;
import com.riwi.Products.services.serviceAbstract.IProductService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final IProductService objIProductService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.objIProductService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(this.objIProductService.getAll());
    }

    @PostMapping
    ResponseEntity<Product> insert(@RequestBody Product objProduct) {
        return ResponseEntity.ok(this.objIProductService.save(objProduct));
    }

    // PathVariable porque el id viene por url
    // RequestBody porque los datos vienen
    @PutMapping(path = "/{id}")
    ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product objProduct) {
        return ResponseEntity.ok(this.objIProductService.update(id, objProduct));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.objIProductService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
