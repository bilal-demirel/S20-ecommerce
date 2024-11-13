package com.demirel.ecommerce.service;

import com.demirel.ecommerce.entity.Category;
import com.demirel.ecommerce.exception.CategoryNotFoundException;
import com.demirel.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Short id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        } else{
            throw new CategoryNotFoundException("Category ID that you entered does not exist!");
        }
    }

    @Override
    public Category addCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category deleteCategoryById(Short id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            categoryRepository.deleteById(id);
            return optionalCategory.get();
        } else {
            throw new CategoryNotFoundException("Category ID that you entered does not exist!");
        }
    }

    @Override
    public Category updateCategory(Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if(optionalCategory.isPresent()){
            optionalCategory.get().setCategoryName(category.getCategoryName());
            categoryRepository.save(optionalCategory.get());
            return optionalCategory.get();
        } else {
            throw new CategoryNotFoundException("Category that you entered does not exist!");
        }
    }
}
