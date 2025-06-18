package com.pluralsight.northwindtraders.api.controller;

import com.pluralsight.northwindtraders.api.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    private List<Product> products = new ArrayList<>();

    public ProductsController() {
        products.add(new Product(1, "Chai", 18.00, 1));
        products.add(new Product(2, "Chang", 19.00, 1));
        products.add(new Product(3, "Aniseed Syrup", 10.00, 2));
        products.add(new Product(5, "Chef Anton's Gumbo Mix", 21.35, 2));
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return products;
    }

    @RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int id) {
        for (Product product : products) {
            if (product.getProductID() == id) {
                return product;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with ID " + id + " not found.");
    }
}


