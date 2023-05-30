package com.exam.examportal.controller;

import com.exam.examportal.model.exam.Category;
import com.exam.examportal.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    //add category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        Category category1 = this.categoryServices.addCategory(category);
        return ResponseEntity.ok(category1);

    }
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId)
    {
        return  this.categoryServices.getCategory(categoryId);
    }

    @GetMapping("/")
    public  ResponseEntity<?> getCategories()
    {
        return  ResponseEntity.ok(this.categoryServices.getCategories());
    }

    @PutMapping("/")
    public  Category updateCategory(@RequestBody Category category)
    {
        return  this.categoryServices.updateCategaory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId)
    {
        this.categoryServices.deleteCategory(categoryId);
    }
    {

    }
}
