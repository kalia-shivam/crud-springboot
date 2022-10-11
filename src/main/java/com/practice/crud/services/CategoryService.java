package com.practice.crud.services;

import com.practice.crud.models.Category;
import com.practice.crud.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getAllCategory() { return categoryRepo.findAll(); }

    public Optional<Category> getCategoryById(int id) {return categoryRepo.findById(id); }

    public Category saveCategory(Category category) {return categoryRepo.save(category); }

    public void deleteCategory(int id) {categoryRepo.deleteById(id);}

    public ResponseEntity<?> updateCategory(Category updateCategory)
    {
        try{
            categoryRepo.save(updateCategory);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
