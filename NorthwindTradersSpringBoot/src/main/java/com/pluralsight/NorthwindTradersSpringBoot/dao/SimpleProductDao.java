package com.pluralsight.NorthwindTradersSpringBoot.dao;


import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {

    private List<Product> products = new ArrayList<>();
    private int nextId = 1;

    public SimpleProductDao() {
        products.add(new Product(nextId++, "iPhone", "Electronics", 999.99));
        products.add(new Product(nextId++, "Coffee Mug", "Kitchenware", 5.99));
        products.add(new Product(nextId++, "Notebook", "Stationery", 2.49));
    }

    @Override
    public void add(Product product) {
        product.setProductId(nextId++);
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
