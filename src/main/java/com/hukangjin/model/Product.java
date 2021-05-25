package com.hukangjin.model;

import java.io.InputStream;

public class Product {

    private int productId;


    private String productName;
    private String productDescription;
    private InputStream picture;
    private double price;
    private int categoryId;

    public Product(){}


    public Product(int productId, String productName, String productDescription, InputStream picture, double price, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.picture = picture;
        this.price = price;
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public InputStream getPicture() {
        return picture;
    }

    public double getPrice() {
        return price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setPicture(InputStream picture) {
        this.picture = picture;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", picture=" + picture +
                ", price=" + price +
                ", categoryId=" + categoryId +
                '}';
    }
}
