package com.pluralsight.northwindtraders.api.controller;

import com.pluralsight.northwindtraders.api.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    private List<Category> categories = new ArrayList<>();

    public CategoriesController() {
        categories.add(new Category(1, "Beverages"));
        categories.add(new Category(2, "Condiments"));
        categories.add(new Category(3, "Coffee & Tea"));
        categories.add(new Category(17, "Pasta"));
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categories;
    }

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable int id) {
        for (Category category : categories) {
            if (category.getCategoryId() == id) {
                return category;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with ID " + id + " not found.");
    }
}


