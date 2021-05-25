package com.hukangjin.model;

import java.io.InputStream;

public class Product {
<<<<<<< HEAD
    private int productId;
=======
    private int productld;
>>>>>>> github.com/master
    private String productName;
    private String productDescription;
    private InputStream picture;
    private double price;
    private int categoryId;

    public Product(){}

<<<<<<< HEAD
    public Product(int productId, String productName, String productDescription, InputStream picture, double price, int categoryId) {
        this.productId = productId;
=======
    public Product(int productld, String productName, String productDescription, InputStream picture, double price, int categoryId) {
        this.productld = productld;
>>>>>>> github.com/master
        this.productName = productName;
        this.productDescription = productDescription;
        this.picture = picture;
        this.price = price;
        this.categoryId = categoryId;
    }

<<<<<<< HEAD
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
=======
    public int getProductld() {
        return productld;
    }

    public void setProductld(int productld) {
        this.productld = productld;
>>>>>>> github.com/master
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
<<<<<<< HEAD
                "productId=" + productId +
=======
                "productld=" + productld +
>>>>>>> github.com/master
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", picture=" + picture +
                ", price=" + price +
                ", categoryId=" + categoryId +
                '}';
    }
}
