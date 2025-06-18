package com.pluralsight.northwindtraders.api.model;


public class Product {

    private int productID;
    private String productName;
    private double unitPrice;
    private int categoryId;

    public Product() {}

    public Product(int productID, String productName, double unitPrice, int categoryId) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", categoryId=" + categoryId +
                '}';
    }
}

