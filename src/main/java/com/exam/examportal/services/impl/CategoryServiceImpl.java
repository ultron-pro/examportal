package com.exam.examportal.services.impl;

import com.exam.examportal.model.exam.Category;
import com.exam.examportal.repo.CategoryRepository;
import com.exam.examportal.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryServices {

     @Autowired
     private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategaory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryID) {
         Category category=new Category();
         category.setCid(categoryID);
      this.categoryRepository.delete(category);
    }
}
