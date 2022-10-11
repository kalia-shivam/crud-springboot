package com.practice.crud.controllers;

import com.practice.crud.models.Category;
import com.practice.crud.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("Category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getAllCategory() { return categoryService.getAllCategory(); }

    @GetMapping("/{Id}")
    public Optional<Category> getCategoryById(@PathVariable("Id") int Id) {return categoryService.getCategoryById(Id); }

    @PostMapping("/")
    public Category saveCategory(@RequestBody Category category) {return categoryService.saveCategory(category); }

    @DeleteMapping("/{Id}")
    public void deleteCategory(@PathVariable("Id") int Id) {categoryService.deleteCategory(Id);}

    @PutMapping("/")
    public ResponseEntity<?> updateCategory(@RequestBody Category updateCategory)
    {
        return categoryService.updateCategory(updateCategory);
    }
}
