package com.demirel.ecommerce.service;

import com.demirel.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Short id);
    Category addCategory(Category category);
    Category deleteCategoryById(Short id);
    Category updateCategory(Category category);
}
