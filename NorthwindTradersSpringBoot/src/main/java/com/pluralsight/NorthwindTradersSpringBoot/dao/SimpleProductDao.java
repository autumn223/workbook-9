package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SimpleProductDao implements ProductDao {

    private List<Product> products = new ArrayList<>();

    private int nextId = 1;

    public SimpleProductDao() {

        products.add(new Product(nextId++, "Chai", 18.0));
        products.add(new Product(nextId++, "Chang", 19.0));
    }

    @Override
    public void add(Product product) {
        product.setProductID(nextId++);
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}

