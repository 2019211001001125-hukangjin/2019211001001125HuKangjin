package com.hukangjin.model;

import java.io.InputStream;

public class Product {
    private int productld;
    private String productName;
    private String productDescription;
    private InputStream picture;
    private double price;
    private int categoryId;

    public Product(){}

    public Product(int productld, String productName, String productDescription, InputStream picture, double price, int categoryId) {
        this.productld = productld;
        this.productName = productName;
        this.productDescription = productDescription;
        this.picture = picture;
        this.price = price;
        this.categoryId = categoryId;
    }

    public int getProductld() {
        return productld;
    }

    public void setProductld(int productld) {
        this.productld = productld;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public InputStream getPicture() {
        return picture;
    }

    public void setPicture(InputStream picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
                "productld=" + productld +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", picture=" + picture +
                ", price=" + price +
                ", categoryId=" + categoryId +
                '}';
    }
}
