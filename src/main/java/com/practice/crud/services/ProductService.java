package com.practice.crud.services;

import com.practice.crud.models.Product;
import com.practice.crud.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProduct() { return productRepo.findAll(); }

    public Optional<Product> getProductById(int id) {return productRepo.findById(id); }

    public Product saveProduct(Product product) {return productRepo.save(product); }

    public void deleteProduct(int id) {productRepo.deleteById(id);}

    public ResponseEntity<?> updateProduct(Product updateProduct)
    {
        try{
            productRepo.save(updateProduct);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
