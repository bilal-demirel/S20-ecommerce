package com.demirel.ecommerce.controller;

import com.demirel.ecommerce.entity.Category;
import com.demirel.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.addCategory(category));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteCategoryById(@PathVariable Short id){
        Category category = categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(category);
    }
}
