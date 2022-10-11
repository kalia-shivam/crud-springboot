package com.practice.crud.controllers;

import com.practice.crud.models.Product;
import com.practice.crud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProduct() { return productService.getAllProduct(); }

    @GetMapping("/{Id}")
    public Optional<Product> getProductById(@PathVariable("Id") int Id) {return productService.getProductById(Id); }

    @PostMapping("/")
    public Product saveProduct(@RequestBody Product product) {return productService.saveProduct(product); }

    @DeleteMapping("/{Id}")
    public void deleteProduct(@PathVariable("Id") int Id) {productService.deleteProduct(Id);}

    @PutMapping("/")
    public ResponseEntity<?> updateProduct(@RequestBody Product updateProduct)
    {
        return productService.updateProduct(updateProduct);
    }
}
