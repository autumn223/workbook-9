package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ProductApp implements CommandLineRunner {

    @Autowired
    private ProductDao productDao;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Product Admin Menu ---");
            System.out.println("1. List Products");
            System.out.println("2. Add Product");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    List<Product> products = productDao.getAll();
                    System.out.println("\nProduct List:");
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;

                case "2":
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter product category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter product price: ");
                    double price;
                    try {
                        price = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price. Please enter a number.");
                        break;
                    }

                    Product product = new Product();
                    product.setProductName(name);
                    product.setUnitPrice(price);

                    productDao.add(product);
                    System.out.println("Product added successfully.");
                    break;

                case "3":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}



