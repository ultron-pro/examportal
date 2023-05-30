package com.exam.examportal.services;

import com.exam.examportal.model.exam.Category;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface CategoryServices {

    public Category  addCategory(Category category);
    public  Category updateCategaory(Category category);
    public Set<Category> getCategories();

    public  Category getCategory(Long categoryId);
    public  void deleteCategory(Long categoryID);
}
