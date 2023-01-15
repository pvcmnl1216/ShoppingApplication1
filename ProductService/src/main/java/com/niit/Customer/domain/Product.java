/*
 * Author Name: Philip Meshach
 * Date: 29-12-2022
 * Praise The Lord
 */
package com.niit.Customer.domain;

import java.util.Objects;

public class Product {
    private int productId;
    private String productName;
    private String productDescription;
    private boolean isUsed;

    public Product() {
    }

    public Product(int productId, String productName, String productDescription, boolean isUsed) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.isUsed = isUsed;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", isUsed=" + isUsed +
                '}';
    }

}